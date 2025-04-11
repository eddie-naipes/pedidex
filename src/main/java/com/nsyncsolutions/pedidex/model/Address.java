package com.nsyncsolutions.pedidex.model;

import com.nsyncsolutions.pedidex.model.enums.StatusType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    @Size(max = 150)
    private String street;
    @NotBlank
    @Size(max = 150)
    private String city;
    @NotBlank
    @Size(max = 150)
    private String addressNotes;

    @Enumerated(EnumType.STRING)
    private StatusType statusType;
}
