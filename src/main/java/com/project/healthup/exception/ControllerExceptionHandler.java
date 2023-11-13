package com.project.healthup.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiError> handleBaseException(BaseException exception) {
        return ResponseEntity.status(exception.getStatus())
                .body(new ApiError(exception.getMessage(), exception.getStatus().value()));
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ApiError> handleConstraintViolationException(ConstraintViolationException exception) {
        List<SubError> subErrors = exception.getConstraintViolations().stream()
                .map(violation -> new SubError(violation.getPropertyPath() + " " + violation.getMessage()))
                .toList();
        return ResponseEntity.badRequest()
                .body(new ApiError("Invalid parameters", HttpStatus.BAD_REQUEST.value(), subErrors));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<SubError> subErrors = exception.getBindingResult().getFieldErrors().stream()
                .map(violation -> new SubError(violation.getField() + " " + violation.getDefaultMessage()))
                .toList();
        return ResponseEntity.badRequest()
                .body(new ApiError("Invalid parameters", HttpStatus.BAD_REQUEST.value(), subErrors));
    }

}
