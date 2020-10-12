package com.alejandro.zemsaniaTest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DETALLE_VENTA")
public class DetalleVenta {

    @Id
    private String idDetalleVenta;
    private String idVenta;
    private String idProducto;
}
