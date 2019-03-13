package org.near.servicesupport.request;

/**
 * 基础请求封装
 *
 * @author willard
 * @date 16-2-26
 */

public class BaseRequest extends AbstractServiceRequest {
    private static final long serialVersionUID = -6289936912859265354L;

    /**
     * 调用方设备名
     */
    protected String clientName;
    /**
     * 调用方IP地址
     */
    protected String clientIp;
    /**
     * 时间戳
     */
    protected long timestamp = System.currentTimeMillis();

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
