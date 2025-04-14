package com.nsyncsolutions.pedidex.dto;

import com.nsyncsolutions.pedidex.model.enums.PaymentMethod;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class OrderRequest {

    private UUID id;

    private UUID clientId;

    private List<OrderedItemDTO> orderedItems;

    private PaymentMethod paymentMethod;
}
