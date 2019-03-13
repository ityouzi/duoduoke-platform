package com.fulihui.duoduoke.demo.common.except;

/**
 * 用户服务错误码区间起始值 102
 *
 * @author lizhi
 */
public interface Errors {
    /**
     * 10201XX
     */

    Integer USERACCOUNT_PREFIX = 1020100;
    /**
     * 10202XX
     */

    Integer TRADE_PREFIX       = 1020200;
    /**
     * 10203XX
     *
     */
    Integer MERCHANT_PREFIX    = 1020300;

    /** 用户账户异常，10201XX */
    enum UserAccount implements IError<Integer> {
                                                 /**
                                                  * 没有余额可提现
                                                  */
                                                 NO_BALANCE_WITHDRAW(1, "没有余额可提现"),;

        Integer errcode;
        String  errmsg;

        UserAccount(Integer errcode, String errmsg) {
            this.errcode = USERACCOUNT_PREFIX + errcode;
            this.errmsg = errmsg;
        }

        @Override
        public Integer errcode() {
            return errcode;
        }

        @Override
        public String errmsg() {
            return errmsg;
        }
    }

    /** 交易异常，10202XX */
    enum Trade implements IError<Integer> {
                                           /**
                                            * 交易已受理，请等候
                                            */
                                           TRADE_UNKNOW(1, "交易已受理，请等候"),;

        Integer errcode;
        String  errmsg;

        Trade(Integer errcode, String errmsg) {
            this.errcode = TRADE_PREFIX + errcode;
            this.errmsg = errmsg;
        }

        @Override
        public Integer errcode() {
            return errcode;
        }

        @Override
        public String errmsg() {
            return errmsg;
        }
    }

}
