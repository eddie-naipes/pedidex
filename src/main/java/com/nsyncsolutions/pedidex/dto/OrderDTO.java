package com.nsyncsolutions.pedidex.dto;

import com.nsyncsolutions.pedidex.model.Client;
import com.nsyncsolutions.pedidex.model.OrderedItem;
import com.nsyncsolutions.pedidex.model.enums.PaymentMethod;
import com.nsyncsolutions.pedidex.model.enums.StatusType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderDTO {

    private UUID id;

    private ClientDTO client;

    private List<OrderedItemDTO> orderedItems;

    private StatusType status;

    private PaymentMethod paymentMethod;

    private BigDecimal totalAmount;
}
