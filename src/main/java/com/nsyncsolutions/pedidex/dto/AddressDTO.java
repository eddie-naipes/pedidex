package com.nsyncsolutions.pedidex.dto;

import com.nsyncsolutions.pedidex.model.enums.StatusType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AddressDTO {

    private UUID id;

    @NotBlank(message = "Street is mandatory")
    @Size(min = 5, max = 50, message = "Street must be between 5 and 50 characters")
    private String street;

    @NotBlank(message = "City is mandatory")
    @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
    private String city;

    private String addressNotes;
    private StatusType statusType;
}