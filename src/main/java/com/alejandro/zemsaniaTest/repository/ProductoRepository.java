package com.alejandro.zemsaniaTest.repository;

import com.alejandro.zemsaniaTest.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, String> {

}
