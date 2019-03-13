package org.near.servicesupport.result;

import org.near.servicesupport.error.CommonServiceErrorEnum;
import org.near.servicesupport.error.ServiceError;

import java.util.List;

/**
 * Created by Willard.Hu on 2016/3/5.
 */
public class ResultBuilder {

    public static BaseResult succ() {
        BaseResult rs = new BaseResult();
        rs.setErrcode(BaseResult.SUCCESS);
        rs.setErrmsg(BaseResult.SUCC_MSG);
        return rs;
    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseResult> T succ(Class<T> clz) {
        try {
            BaseResult rs = clz.newInstance();
            rs.setErrcode(BaseResult.SUCCESS);
            rs.setErrmsg(BaseResult.SUCC_MSG);
            return (T) rs;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends PageResult> T succPageResult(Class<T> clz, int page, int rows,
                                                          int totalCount) {
        try {
            PageResult rs = clz.newInstance();
            rs.setPage(page);
            rs.setRows(rows);
            int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
            rs.setTotalPage(totalPage > 0 ? totalPage : 1);
            rs.setTotalRows(totalCount);
            rs.setErrcode(BaseResult.SUCCESS);
            rs.setErrmsg(BaseResult.SUCC_MSG);
            return (T) rs;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> TSingleResult<T> succTSingle(T value) {
        TSingleResult<T> result = new TSingleResult<>();
        result.setValue(value);
        result.setErrcode(BaseResult.SUCCESS);
        result.setErrmsg(BaseResult.SUCC_MSG);
        return result;
    }

    public static <T> TMultiResult<T> succTMulti(List<T> values) {
        TMultiResult<T> result = new TMultiResult<>();
        result.setValues(values);
        result.setErrcode(BaseResult.SUCCESS);
        result.setErrmsg(BaseResult.SUCC_MSG);
        return result;
    }

    public static <T> TPageResult<T> succTPage(List<T> values, int page, int rows, int totalCount) {
        TPageResult<T> result = new TPageResult<>();
        result.setValues(values);
        result.setPage(page);
        result.setRows(rows);
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        result.setTotalPage(totalPage > 0 ? totalPage : 1);
        result.setTotalRows(totalCount);
        result.setErrcode(BaseResult.SUCCESS);
        result.setErrmsg(BaseResult.SUCC_MSG);
        return result;
    }

    public static BaseResult fail(int errcode, String errmsg) {
        BaseResult rs = new BaseResult();
        rs.setErrcode(errcode);
        rs.setErrmsg(errmsg);
        return rs;
    }

    public static BaseResult fail(ServiceError err) {
        if (err == null) {
            err = CommonServiceErrorEnum.SYSTEM_ERROR;
        }
        return fail(err.getErrcode(), err.getErrmsg());
    }

    public static <T extends BaseResult> T fail(Class<T> clz, ServiceError error) {
        if (error == null) {
            error = CommonServiceErrorEnum.SYSTEM_ERROR;
        }
        return fail(clz, error.getErrcode(), error.getErrmsg());
    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseResult> T fail(Class<T> clz, int errcode, String errmsg) {
        try {
            BaseResult rs = clz.newInstance();
            rs.setErrcode(errcode);
            rs.setErrmsg(errmsg);
            return (T) rs;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> TSingleResult<T> failTSingle(ServiceError error) {
        if (error == null) {
            error = CommonServiceErrorEnum.SYSTEM_ERROR;
        }
        return failTSingle(error.getErrcode(), error.getErrmsg());
    }

    public static <T> TSingleResult<T> failTSingle(int errcode, String errmsg) {
        TSingleResult<T> result = new TSingleResult<>();
        result.setErrcode(errcode);
        result.setErrmsg(errmsg);
        return result;
    }

    public static <T> TMultiResult<T> failTMulti(ServiceError error) {
        if (error == null) {
            error = CommonServiceErrorEnum.SYSTEM_ERROR;
        }
        return failTMulti(error.getErrcode(), error.getErrmsg());
    }

    public static <T> TMultiResult<T> failTMulti(int errcode, String errmsg) {
        TMultiResult<T> result = new TMultiResult<>();
        result.setErrcode(errcode);
        result.setErrmsg(errmsg);
        return result;
    }

    public static <T> TPageResult<T> failTPage(ServiceError error) {
        if (error == null) {
            error = CommonServiceErrorEnum.SYSTEM_ERROR;
        }
        return failTPage(error.getErrcode(), error.getErrmsg());
    }

    public static <T> TPageResult<T> failTPage(int errcode, String errmsg) {
        TPageResult<T> result = new TPageResult<>();
        result.setErrcode(errcode);
        result.setErrmsg(errmsg);
        return result;
    }
}
