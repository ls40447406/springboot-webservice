package com.lishuo.springboot.exception;


/**
 * 服务层异常类
 */
public class ServiceException  extends  BaseException {

    private static final long serialVersionUID = 6058294324031642376L;

    public ServiceException() {}

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String code, String message) {
        super(code, message);
    }

}
