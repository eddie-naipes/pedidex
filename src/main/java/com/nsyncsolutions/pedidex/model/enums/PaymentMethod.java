package com.nsyncsolutions.pedidex.model.enums;

import lombok.Getter;

@Getter
public enum PaymentMethod {

    CASH("CASH"),
    CREDIT_CARD("CREDIT_CARD"),
    DEBIT_CARD("DEBIT_CARD"),
    BANK_TRANSFER("BANK_TRANSFER");

    private final String method;

    PaymentMethod(String method) {
        this.method = method;
    }

}
