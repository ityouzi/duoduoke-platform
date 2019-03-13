package org.near.webmvcsupport.error;

/**
 * 业务系统创建枚举继承此类<br>
 * public enum CommonErrorEnum implements CommonError {<br>
 *     SYSTEM_ERROR("code", "message"), ... ;<br>
 *     private String code;<br>
 *     private String message;<br>
 *     <br>
 *     CommonErrorEnum(String code, String message) {<br>
 *         this.code = code;<br>
 *         this.message = message;<br>
 *     }<br>
 *     <br>
 *     public String getErrorCode() { return this.code; }<br>
 *     <br>
 *     public String getErrorMessage() { return this.message; }<br>
 * }<br>
 * Created by Willard.Hu on 2016/5/9.
 */
public interface CommonError {

    String getErrorCode();

    String getErrorMessage();

}
