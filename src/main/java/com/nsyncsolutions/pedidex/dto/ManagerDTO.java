package com.nsyncsolutions.pedidex.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ManagerDTO {

    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
}
