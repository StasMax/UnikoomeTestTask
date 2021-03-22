package org.example.userapi.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class ServiceException extends RuntimeException{

    private HttpStatus httpStatus;
    private static final String DEFAULT_MESSAGE = "Что-то пошло не так";

    public ServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public ServiceException(String message) {
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public ServiceException(String message, HttpStatus httpStatus, Throwable e) {
        super(message, e);
        this.httpStatus = httpStatus;
    }

    public ServiceException(HttpStatus httpStatus, Throwable e) {
        super(DEFAULT_MESSAGE, e);
        this.httpStatus = httpStatus;
    }

}
