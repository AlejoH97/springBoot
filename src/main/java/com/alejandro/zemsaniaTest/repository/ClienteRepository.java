package com.alejandro.zemsaniaTest.repository;

import com.alejandro.zemsaniaTest.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
