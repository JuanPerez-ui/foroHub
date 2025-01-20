package com.aluracursos.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.aluracursos.usuario.UsuarioRepository;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private  TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("este es el inicio del filtro");
        var authHeader  = request.getHeader("Authorization");//.replace("Bearer ","");

        if (authHeader != null)
        {
            System.out.println("validamos el token, no es null");
            var token = authHeader.replace("Bearer ","");
            System.out.println(token);

            var nombreUsuario = tokenService.getSubject(token);
            if (nombreUsuario != null){
                //token valido
                var usuario = usuarioRepository.findByLogin(nombreUsuario);
                var autehntication = new UsernamePasswordAuthenticationToken(usuario,null,
                        usuario.getAuthorities()); //forzamos el inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(autehntication);
            }
        }
        filterChain.doFilter(request,response);
    }
}

