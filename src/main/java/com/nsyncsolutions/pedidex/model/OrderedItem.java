package com.nsyncsolutions.pedidex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "ordered_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderedItem {

    @Id
    @UuidGenerator
    private UUID id;

    @OneToOne
    private Product product;

    private Integer quantity;

}
