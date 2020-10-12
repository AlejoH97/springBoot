package com.alejandro.zemsaniaTest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLIENTE")
public class Cliente {
    @Id
    private String idCliente;
    private String nombre;
    private String apellido;
    private int dni;
    private int telefono;
    private String email;
}
