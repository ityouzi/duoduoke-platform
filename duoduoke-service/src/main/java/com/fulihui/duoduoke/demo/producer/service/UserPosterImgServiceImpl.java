package com.fulihui.duoduoke.demo.producer.service;


import com.fulihui.duoduoke.demo.api.api.UserPosterImgService;
import com.fulihui.duoduoke.demo.api.dto.UserPosterImgDTO;
import com.fulihui.duoduoke.demo.api.request.UserPosterImgRequest;
import com.fulihui.duoduoke.demo.api.request.UserQrcodeImgRequest;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserPosterImg;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserShareRecord;
import com.fulihui.duoduoke.demo.producer.manager.AppSendMessageManager;
import com.fulihui.duoduoke.demo.producer.repository.UserPosterImgRepository;
import com.fulihui.duoduoke.demo.producer.repository.UserShareRecodeRepository;
import com.fulihui.duoduoke.demo.producer.dal.convert.UserPosterImgConvert;
import com.fulihui.duoduoke.demo.producer.util.ImageUtil;
import com.fulihui.duoduoke.demo.common.util.AliyunOSSClientUtil;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/30 0030 19:12
 */
@Service(version = "${demo.service.version}")

public class UserPosterImgServiceImpl implements UserPosterImgService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPosterImgServiceImpl.class);
    static InputStream resourceAsStream1;
    static InputStream resourceAsStream2;
    static InputStream resourceAsStream3;
    @Autowired
    private UserPosterImgRepository userPosterImgRepository;
    @Autowired
    private AppSendMessageManager appSendMessageManager;
    @Autowired
    private UserShareRecodeRepository userShareRecodeRepository;
    @Autowired
    private AliyunOSSClientUtil aliyunOSSClientUtil;

    @Override
    public TMultiResult<UserPosterImgDTO> query(UserPosterImgRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        String userId = request.getUserId();

        List<UserPosterImgDTO> list = userPosterImgRepository.query(userId);

        if (CollectionUtils.isEmpty(list)) {
            ServiceAssert.notNull(request.getHeadImg(), Errors.Commons.REQUEST_PARAMETER_ERROR);
            ServiceAssert.notNull(request.getNickName(), Errors.Commons.REQUEST_PARAMETER_ERROR);
            BufferedImage weixinCode = appSendMessageManager.getWeixinCode("uid=" + userId);
            try {
                if (weixinCode == null) {
                    return ResultBuilder.failTMulti(1001, "二维码为空");
                }
                BufferedImage headImageBuffer = ImageIO.read(new URL(request.getHeadImg()));
                BufferedImage head = ImageUtil.thumbnail(headImageBuffer, 90, 90);

                resourceAsStream1 = UserPosterImgServiceImpl.class.getClassLoader().getResourceAsStream("static/images/advert1.png");
                resourceAsStream2 = UserPosterImgServiceImpl.class.getClassLoader().getResourceAsStream("static/images/advert2.png");
                resourceAsStream3 = UserPosterImgServiceImpl.class.getClassLoader().getResourceAsStream("static/images/advert3.png");
                InputStream inputStream1 = ImageUtil.compoundQrcode(resourceAsStream1, weixinCode, head, request.getNickName());
                InputStream inputStream2 = ImageUtil.compoundQrcode(resourceAsStream2, weixinCode, head, request.getNickName());
                InputStream inputStream3 = ImageUtil.compoundQrcode(resourceAsStream3, weixinCode, head, request.getNickName());
                if (inputStream1 != null && inputStream2 != null && inputStream3 != null) {
                    InputStream[] inputStreams = {inputStream1, inputStream2, inputStream3};
                    String[] fileNames = {userId + "one.png", userId + "two.png", userId + "three.png"};
                    List<String> imgList = aliyunOSSClientUtil.uploadImageToOSS(fileNames, inputStreams);
                    List<UserPosterImg> userPosterImgDTOSlist = new ArrayList<>();
                    if (!CollectionUtils.isEmpty(imgList)) {
                        for (int i = 0; i < imgList.size(); i++) {
                            UserPosterImg userPosterImg = new UserPosterImg();
                            userPosterImg.setUserId(userId);
                            userPosterImg.setPosterImg(imgList.get(i));
                            int insert = userPosterImgRepository.insert(userPosterImg);
                            userPosterImgDTOSlist.add(userPosterImg);
                        }
                        return ResultBuilder.succTMulti(UserPosterImgConvert.convert(userPosterImgDTOSlist));
                    }
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return ResultBuilder.succTMulti(list);
    }

    @Override
    public TSingleResult<String> goodsQrcodeImg(UserQrcodeImgRequest request) {
        String goodsId = request.getGoodsId();
        String userId = request.getUid();
        UserShareRecord record = new UserShareRecord();
        record.setGoodId(goodsId);
        record.setUserId(userId);
        record.setPid(request.getSharePid());
        int shareId = userShareRecodeRepository.insert(record);
        LOGGER.info("shareId:{}", record.getId());
        InputStream inputStream = appSendMessageManager.weixinCode("id=" + record.getId(), "product");
        String imgUrl = aliyunOSSClientUtil.uploadImageToOSS(userId + goodsId + ".png", inputStream);
        String replace = imgUrl.replace("http:", "https:");
        LOGGER.info("imgUrl:{}", replace);
        return ResultBuilder.succTSingle(replace);
    }


}
