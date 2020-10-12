package com.alejandro.zemsaniaTest.controller;

import com.alejandro.zemsaniaTest.models.Venta;
import com.alejandro.zemsaniaTest.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VentaController {

    @Autowired
    VentaRepository ventaRepository;

    @GetMapping("/venta/{id}")
    public Venta buscarVenta(@PathVariable String id) {
        Optional<Venta> venta = ventaRepository.findById(id);
        if (venta.isPresent()) {
            return venta.get();
        } else {
            throw new VentaNoEncontradaException();
        }
    }

    @PostMapping("/venta")
    public Venta registrarVenta(@RequestBody Venta venta) throws Exception {
        ventaRepository.save(venta);
        return venta;
    }
}

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Venta no encontrada")
class VentaNoEncontradaException extends RuntimeException {

}
