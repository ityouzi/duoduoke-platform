package com.fulihui.duoduoke.demo.api.constant;

public class MessageConstant {
    public static  class ResultCode{
        //位置编码为空！
        public static Integer PositionIdIsNull=301;
        public static Integer PositionIsNull=302;
        public static Integer BannerIsNull=303;
        //数据插入失败！
        public static Integer MysqlInsertFailed=399;
    }

    public static  class ResultMessage{
        //位置编码为空！
        public static String PositionIdIsNull="模块编码和位置编码的Id传值不能为空!";
        public static String PositionIsNull="位置不存在!";
        public static String BannerIsNull="Banner不存在!";
        public static String MysqlInsertFailed="Mysql数据插入失败!";
    }

}
