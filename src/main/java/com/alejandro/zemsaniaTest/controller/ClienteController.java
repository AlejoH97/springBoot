package com.alejandro.zemsaniaTest.controller;

import com.alejandro.zemsaniaTest.models.AuthRequest;
import com.alejandro.zemsaniaTest.models.Cliente;
import com.alejandro.zemsaniaTest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping("/cliente")
    public Cliente registrarCliente(@RequestBody Cliente cliente) throws Exception {
        clienteRepository.save(cliente);
        return cliente;
    }
}
