package com.nsyncsolutions.pedidex.model.enums;

import lombok.Getter;

@Getter
public enum StatusType {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    PENDING("PENDING"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED");

    private final String status;

    StatusType(String status) {
        this.status = status;
    }

}
