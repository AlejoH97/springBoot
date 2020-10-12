package com.alejandro.zemsaniaTest.controller;

import com.alejandro.zemsaniaTest.models.AuthRequest;
import com.alejandro.zemsaniaTest.util.JwtUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    private static Logger logger = LogManager.getLogger(IndexController.class);

    @GetMapping("/")
    public String welcome() {
        return "hi";
    }

    @PostMapping("/auth")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception e) {
            logger.info("Datos incorrectos en logueo");
            throw new Exception("Wrong username or password");
        }
        logger.info("Logueo exitoso");
        return jwtUtil.generateToken(authRequest.getUsername());
    }
}
