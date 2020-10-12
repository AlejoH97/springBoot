package com.alejandro.zemsaniaTest.controller;

import com.alejandro.zemsaniaTest.models.Producto;
import com.alejandro.zemsaniaTest.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductoController {

    @Autowired
    ProductoRepository productoRepository;

    @GetMapping("/producto/{id}")
    public Producto buscarProducto(@PathVariable String id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            return producto.get();
        } else {
            throw new ProductoNoEncontradaException();
        }
    }

    @PostMapping("/producto")
    public Producto registrarProducto(@RequestBody Producto producto) throws Exception {
        productoRepository.save(producto);
        return producto;
    }

    @PutMapping("/producto/{id}")
    public Producto editarProducto(@RequestBody Producto newProducto, @PathVariable String id) throws Exception {
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setNombre(newProducto.getNombre());
                    producto.setPrecio(newProducto.getPrecio());
                    return productoRepository.save(producto);
                }).orElseGet(() -> {
                    newProducto.setIdProducto(id);
                    return productoRepository.save(newProducto);
                });
    }

    @DeleteMapping("/producto/{id}")
    void eliminarProducto(@PathVariable String id) {
        productoRepository.deleteById(id);
    }

}

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Producto no encontrada")
class ProductoNoEncontradaException extends RuntimeException {

}