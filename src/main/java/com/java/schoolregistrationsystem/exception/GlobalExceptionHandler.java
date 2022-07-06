package com.java.schoolregistrationsystem.exception;

import com.java.schoolregistrationsystem.model.ApiError;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ApiError> entityNotFoundExceptionHandler(EntityNotFoundException e) {
        if (e.getMessage().equals("STUDENT")) {
            return new ResponseEntity<>(new ApiError("Student with given name does not exist"), HttpStatus.BAD_REQUEST);
        } else if (e.getMessage().equals("COURSE")) {
            return new ResponseEntity<>(new ApiError("Course with given name does not exist"), HttpStatus.BAD_REQUEST);
        } else return new ResponseEntity<>(new ApiError("Incorrect input"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<List<ApiError>> methodArgumentNotValidExceptionHandler(final MethodArgumentNotValidException e) {
        List<ApiError> apiErrors = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .map(ApiError::new).toList();
        return new ResponseEntity<>(apiErrors, HttpStatus.BAD_REQUEST);
    }
}
