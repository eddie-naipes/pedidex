package com.nsyncsolutions.pedidex.model;

import com.nsyncsolutions.pedidex.model.enums.StatusType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "DDD is mandatory")
    private String ddd;

    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;

    @NotBlank(message = "Phone type is mandatory")
    private String phoneType;

    @NotNull(message = "Status type is mandatory")
    @Enumerated(EnumType.STRING)
    private StatusType statusType;
}
