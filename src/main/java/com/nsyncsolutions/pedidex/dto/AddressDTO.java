package com.nsyncsolutions.pedidex.dto;

import com.nsyncsolutions.pedidex.model.enums.StatusType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AddressDTO {
    private UUID id;
    private String street;
    private String city;
    private String addressNotes;
    private StatusType statusType;
}