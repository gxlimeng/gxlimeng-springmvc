package com.duopei.springmvc.config.advice;

/**
 * Created by Administrator on 2017/1/13.
 *
 * 抛出此类异常：事务会回滚
 */
public class MyThrowException extends RuntimeException {

    public MyThrowException(){
        super();
    }

    public MyThrowException(String message) {
        super(message);
    }

    public MyThrowException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyThrowException(Throwable cause) {
        super(cause);
    }

    public MyThrowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
