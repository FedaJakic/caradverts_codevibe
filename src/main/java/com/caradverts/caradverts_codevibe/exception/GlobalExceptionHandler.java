package com.caradverts.caradverts_codevibe.exception;

import jakarta.persistence.EntityNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleNotFoundException(EntityNotFoundException ex) {
                HttpStatus status = HttpStatus.NOT_FOUND;

                return new ResponseEntity<>(
                                new ErrorResponse(
                                                status,
                                                "This is returned if a car advert with given id is not found."),
                                status);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
                List<String> errors = ex.getBindingResult().getFieldErrors()
                                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
                return new ResponseEntity<>(getErrorsForValidation(errors), new HttpHeaders(),
                                HttpStatus.UNPROCESSABLE_ENTITY);
        }

        @ExceptionHandler(HttpMessageNotReadableException.class)
        public final ResponseEntity<ErrorResponse> handleMessageNotReadable(Exception ex) {
                HttpStatus status = HttpStatus.BAD_REQUEST;

                return new ResponseEntity<>(
                                new ErrorResponse(
                                                status,
                                                "This is returned if json is invalid or cannot be parsed."),
                                status);
        }

        @ExceptionHandler(RuntimeException.class)
        public final ResponseEntity<ErrorResponse> handleRuntimeExceptions(RuntimeException ex) {
                HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

                return new ResponseEntity<>(
                                new ErrorResponse(
                                                status,
                                                ex.toString()),
                                status);
        }

        private Map<String, List<String>> getErrorsForValidation(List<String> errors) {
                Map<String, List<String>> errorResponse = new HashMap<>();
                errorResponse.put("validation_errors", errors);
                return errorResponse;
        }
}
