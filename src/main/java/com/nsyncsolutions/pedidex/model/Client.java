package com.nsyncsolutions.pedidex.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "First name is mandatory")
    @Size(min = 1, max = 255)
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 1, max = 255, message = "Last name should be between 1 and 255 characters")
    private String lastName;

    @NotBlank
    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = CLIENT_ID)
    private List<Phone> phone;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = CLIENT_ID)
    private List<Address> addresses;
}