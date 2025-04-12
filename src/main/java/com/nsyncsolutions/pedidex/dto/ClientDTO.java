package com.nsyncsolutions.pedidex.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ClientDTO {

    private UUID id;

    @NotBlank(message = "First name is mandatory")
    @Size(min = 5, max = 50, message = "First name must be between 5 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 5, max = 50, message = "Last name must be between 5 and 50 characters")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotNull(message = "Phone list is mandatory")
    private List<PhoneDTO> phone;

    @NotNull(message = "Address list is mandatory")
    private List<AddressDTO> addresses;
}