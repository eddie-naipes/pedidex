package com.nsyncsolutions.pedidex.exceptions;

import com.nsyncsolutions.pedidex.exceptions.error.ErrorTemplate;
import com.nsyncsolutions.pedidex.exceptions.error.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ErrorTemplate> handleValidationExceptions(
            MethodArgumentNotValidException ex,
            WebRequest request) {

        List<ValidationError> validationErrors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            ValidationError validationError = new ValidationError(fieldName, errorMessage);
            validationErrors.add(validationError);
        });

        ErrorTemplate errorTemplate = ErrorTemplate.builder()
                .error("Validation Error")
                .message("There were validation errors")
                .path(request.getDescription(false).replace("uri=", ""))
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .status(HttpStatus.BAD_REQUEST.value())
                .errorCode("VALIDATION_ERROR")
                .validationErrors(validationErrors)
                .build();

        return new ResponseEntity<>(errorTemplate, HttpStatus.BAD_REQUEST);
    }
}