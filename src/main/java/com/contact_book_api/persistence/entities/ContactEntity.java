package com.contact_book_api.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contact")
@Getter
@Setter
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Es obligatorio ingresar el nombre.")
    @Column(length = 100, nullable = false)
    private String name;

    @NotBlank(message = "Es obligatorio ingresar el correo electrónico.")
    @Column(length = 120, unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Es obligatorio ingresar el número de celular.")
    @Column(length = 20, unique = true, nullable = false)
    private String phoneNumber;
}
