package com.nsyncsolutions.pedidex.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ClientDTO {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private List<PhoneDTO> phone;
    private List<AddressDTO> addresses;
}