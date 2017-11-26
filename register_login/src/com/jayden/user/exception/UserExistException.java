package com.jayden.user.exception;

/**
 * 自定义异常类，用于在用户名已经被注册过时返回信息
 */
public class UserExistException extends Exception{
    public UserExistException() {
        super();
    }

    public UserExistException(String message) {
        super(message);
    }

    public UserExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistException(Throwable cause) {
        super(cause);
    }

    protected UserExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
