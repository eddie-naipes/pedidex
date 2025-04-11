package com.nsyncsolutions.pedidex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

import static com.nsyncsolutions.pedidex.utils.TableConstants.PX_MANAGER;

@Entity
@Table(name = PX_MANAGER)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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
