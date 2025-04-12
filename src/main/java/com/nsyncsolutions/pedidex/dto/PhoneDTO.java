package com.nsyncsolutions.pedidex.dto;

import com.nsyncsolutions.pedidex.model.enums.StatusType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PhoneDTO {


    private UUID id;

    @NotBlank(message = "DDD is mandatory")
    @Size(min = 2, max = 2, message = "DDD must be 2 characters")
    private String ddd;

    @NotBlank
    @Size(min = 8, max = 9, message = "Phone number must be between 8 and 9 characters")
    private String phoneNumber;

    private String phoneType;

    @NotBlank(message = "Phone type is mandatory")
    private StatusType statusType;
}