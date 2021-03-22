package org.example.userapi.common.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class AppExceptionHandler {

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<ApiError> handleServiceException(HttpServletRequest req, ServiceException ex) {
        String message = ex.getMessage();
        log.error(message, ex);
        ApiError error = ApiError.create(ex.getHttpStatus(), ex, message, req.getRequestURL());
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }

    @ExceptionHandler({JsonProcessingException.class})
    public ResponseEntity<ApiError> handleJsonProcessingException(HttpServletRequest req, JsonProcessingException ex) {
        String message = ex.getMessage();
        log.error(message, ex);
        ApiError error = ApiError.create(HttpStatus.BAD_REQUEST, ex, "Некорректный запрос \n" + message,
                req.getRequestURL());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
