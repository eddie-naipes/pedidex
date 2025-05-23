package com.nsyncsolutions.pedidex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

import static com.nsyncsolutions.pedidex.utils.TableConstants.PX_MANAGER;

@Entity
@Table(name = PX_MANAGER)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Manager {

    @Id
    @UuidGenerator
    private UUID id;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
}
