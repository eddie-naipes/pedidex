package com.nsyncsolutions.pedidex.exceptions.error;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ErrorTemplate {
    private String error;
    private String message;
    private String path;
    private String timestamp;
    private int status;
    private String errorCode;
    private List<ValidationError> validationErrors;
}