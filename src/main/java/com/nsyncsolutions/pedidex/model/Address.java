package com.nsyncsolutions.pedidex.model;

import com.nsyncsolutions.pedidex.model.enums.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

import static com.nsyncsolutions.pedidex.utils.TableConstants.PX_ADDRESS;

@Entity
@Table(name = PX_ADDRESS)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @UuidGenerator
    private UUID id;
    private String street;
    private String city;
    private String addressNotes;

    @Enumerated(EnumType.STRING)
    private StatusType statusType;
}
