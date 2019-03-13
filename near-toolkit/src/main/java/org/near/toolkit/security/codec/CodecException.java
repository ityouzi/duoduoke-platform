package org.near.toolkit.security.codec;

/**
 * 编码错误
 * Created by Willard on 2015/9/21.
 */
public class CodecException extends RuntimeException {
    private static final long serialVersionUID = -3910798126410535501L;

    public CodecException() {
        super();
    }

    public CodecException(String message) {
        super(message);
    }

    public CodecException(Throwable cause) {
        super(cause);
    }

    public CodecException(String message, Throwable cause) {
        super(message, cause);
    }
}
