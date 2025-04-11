package com.nsyncsolutions.pedidex.dto;

import com.nsyncsolutions.pedidex.model.enums.StatusType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PhoneDTO {
    private UUID id;
    private String ddd;
    private String phoneNumber;
    private String phoneType;
    private StatusType statusType;
}