package com.duopei.springmvc.config.advice;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017/1/24.
 */
public class MySQLException extends SQLException{

    public MySQLException(){
        super();
    }

    public MySQLException(String message) {
        super(message);
    }

    public MySQLException(String message, Throwable cause) {
        super(message, cause);
    }

    public MySQLException(Throwable cause) {
        super(cause);
    }


}
