package com.project.healthup.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiError> handleBaseException(BaseException exception) {
        return ResponseEntity.status(exception.getStatus())
                .body(new ApiError(exception.getMessage(), exception.getStatus().value()));
    }

}
