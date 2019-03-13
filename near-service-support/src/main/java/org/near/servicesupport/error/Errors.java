package org.near.servicesupport.error;

/**
 * @author Willard.Hu on 2016/11/16 0016.
 */
public class Errors {

    public enum Commons implements ServiceError {

        SYSTEM_ERROR(100, "系统异常"),

        REQUEST_PARAMETER_ERROR(101, "请求参数错误");

        int    errcode;
        String errmsg;

        Commons(int errcode, String errmsg) {
            this.errcode = errcode;
            this.errmsg = errmsg;
        }

        @Override
        public int getErrcode() {
            return errcode;
        }

        @Override
        public String getErrmsg() {
            return errmsg;
        }
    }
}
