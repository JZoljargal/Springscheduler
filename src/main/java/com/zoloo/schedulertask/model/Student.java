package com.zoloo.schedulertask.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "First Name may not be null")
    @NotBlank(message = "First Name may not be blank")
    @Column(name = "firstname")
    private String firstName;

    @NotNull(message = "Last Name may not be null")
    @NotBlank(message = "Last Name may not be blank")
    @Column(name = "lastname")
    private String lastName;

    @NotNull(message = "Register may not be null")
    @NotBlank(message = "Register may not be blank")
    @Column(name = "register")
    private String register;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email should be valid")
    @Column(name = "email")
    private String email;

}