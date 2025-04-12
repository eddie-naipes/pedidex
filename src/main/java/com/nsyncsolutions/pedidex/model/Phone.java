package com.nsyncsolutions.pedidex.model;

import com.nsyncsolutions.pedidex.model.enums.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

import static com.nsyncsolutions.pedidex.utils.TableConstants.PX_PHONE;

@Entity
@Table(name = PX_PHONE)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Phone {

    @Id
    @UuidGenerator
    private UUID id;

    private String ddd;

    private String phoneNumber;

    private String phoneType;

    @Enumerated(EnumType.STRING)
    private StatusType statusType;
}
