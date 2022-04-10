package com.randrin.request.validation.exception.exception.handler;

import com.randrin.request.validation.exception.exception.UserFoundException;
import com.randrin.request.validation.exception.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class UserServiceExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<String> errors = fieldErrors
                .stream()
                .map(err -> err.getField() + ":" + err.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError apiError = new ApiError();
        apiError.setErrors(errors);
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setPath(request.getDescription(false));
        apiError.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({UserNotFoundException.class})
    ResponseEntity<?> UserNotFoundHandler(Exception exception, ServletWebRequest request) {

        ApiError apiError = new ApiError();

        apiError.setTimestamp(LocalDateTime.now());
        apiError.setStatus(HttpStatus.NOT_FOUND);
        apiError.setErrors(Arrays.asList(exception.getMessage()));
        apiError.setPath(request.getDescription(true));

        return new ResponseEntity(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({UserFoundException.class})
    ResponseEntity<?> UserFoundHandler(Exception exception, ServletWebRequest request) {

        ApiError apiError = new ApiError();

        apiError.setTimestamp(LocalDateTime.now());
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setErrors(Arrays.asList(exception.getMessage()));
        apiError.setPath(request.getDescription(true));

        return new ResponseEntity(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
