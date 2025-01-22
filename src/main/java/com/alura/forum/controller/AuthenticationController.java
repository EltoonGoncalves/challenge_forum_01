package com.alura.forum.controller;

import com.alura.forum.domain.author.Author;
import com.alura.forum.domain.author.LoginDTO;
import com.alura.forum.infra.security.JWTDTO;
import com.alura.forum.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<JWTDTO> login(@RequestBody @Valid LoginDTO loginDTO){
        var authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password());
        var authentication = authenticationManager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((Author) authentication.getPrincipal());
        return ResponseEntity.ok(new JWTDTO(tokenJWT));
    }
}
