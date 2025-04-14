package com.nsyncsolutions.pedidex.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

import static com.nsyncsolutions.pedidex.utils.TableConstants.CLIENT_ID;
import static com.nsyncsolutions.pedidex.utils.TableConstants.PX_CLIENT;

@Entity
@Table(name = PX_CLIENT)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Client {

    @Id
    @UuidGenerator
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = CLIENT_ID)
    private List<Phone> phone;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = CLIENT_ID)
    private List<Address> addresses;
}