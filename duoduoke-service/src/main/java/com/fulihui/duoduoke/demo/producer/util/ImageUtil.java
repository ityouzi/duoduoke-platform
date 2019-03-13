package com.fulihui.duoduoke.demo.producer.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/30 0030 9:56
 */
public class ImageUtil {
    protected final static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    public static InputStream compoundQrcode(InputStream image, BufferedImage qrcodeImg, BufferedImage headImageBuffer, String nikeName) {
        ByteArrayOutputStream bos = null;
        try {

            BufferedImage backImage = ImageIO.read(image);
            Graphics2D g2d = backImage.createGraphics();
            g2d.drawImage(qrcodeImg, 190, 480, qrcodeImg.getWidth(), qrcodeImg.getHeight(), null);
            g2d.drawImage(headImageBuffer, 49, 35, headImageBuffer.getWidth(), headImageBuffer.getHeight(), null);
            g2d.setFont(new Font("微软雅黑", Font.PLAIN, 32));
            g2d.setColor(new Color(255, 255, 255));
            g2d.drawString(nikeName, 170, 80);

            g2d.dispose();
            bos = new ByteArrayOutputStream();
            ImageIO.write(backImage, "png", bos);

            return new ByteArrayInputStream(bos.toByteArray());
        } catch (IOException e) {
            logger.error("合成二维码图片失败！", e);
        } finally {
            if (Objects.nonNull(bos)) {
                try {
                    bos.close();
                } catch (IOException e) {
                    logger.error("关闭文件流异常！", e);
                }
            }
        }
        return null;
    }

    public static BufferedImage thumbnail(BufferedImage img, int width, int height) throws IOException {
        Image image = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        BufferedImage tag = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = tag.getGraphics();
        g.drawImage(image, 0, 0, null); // 绘制处理后的图
        g.dispose();
        return tag;
    }


    public static BufferedImage thumbnailImg(BufferedImage img, int width, int height) throws IOException {
        //Image image = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        BufferedImage tag = new BufferedImage(width, height,
                BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = tag.createGraphics();
        Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, width, height);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setBackground(Color.black);
        g.setClip(shape);
        g.drawImage(img, 0, 0, null); // 绘制处理后的图
        g.dispose();
        return tag;
    }


    public static BufferedImage readImage(String image) {
        URLConnection httpUrlConnection = null;
        try {
            httpUrlConnection = new URL(image).openConnection();

            InputStream in = httpUrlConnection.getInputStream();
            BufferedImage img = ImageIO.read(in);
            return img;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("微信图片读取失败！", e);
        }
        return null;
    }


}
