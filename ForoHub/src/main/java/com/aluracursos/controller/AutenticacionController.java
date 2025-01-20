package com.aluracursos.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aluracursos.infra.security.DatosJWTToken;
import com.aluracursos.infra.security.TokenService;
import com.aluracursos.usuario.DatosAutenticacionUsuario;
import com.aluracursos.usuario.Usuario;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUusario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){

        Authentication authtoken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),
                datosAutenticacionUsuario.clave());
        System.out.println("llego a este punto");
        var usuarioAutenticado = authenticationManager.authenticate(authtoken);
        var JWtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWtoken,"bearer"));
    }


}
