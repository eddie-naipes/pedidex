package com.nsyncsolutions.pedidex.dto;

import com.nsyncsolutions.pedidex.model.Product;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class OrderedItemDTO {

    private UUID id;

    @NotNull
    private Product product;

    @NotNull
    @Min(value = 1, message = "Quantity must be at least 1")
    @Max(value = 10, message = "Quantity must be at most 10")
    private Integer quantity;
}
