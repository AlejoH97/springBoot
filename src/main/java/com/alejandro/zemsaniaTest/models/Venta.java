package com.alejandro.zemsaniaTest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VENTA")
public class Venta {

    @Id
    private String idVenta;
    private String idCliente;
    private Date fecha;
}
