package com.nsyncsolutions.pedidex.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProductDTO {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
}
