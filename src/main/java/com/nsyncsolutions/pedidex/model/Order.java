package com.nsyncsolutions.pedidex.model;

import com.nsyncsolutions.pedidex.model.enums.PaymentMethod;
import com.nsyncsolutions.pedidex.model.enums.StatusType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Order {

    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderedItem> orderedItems;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private BigDecimal totalAmount;

}
