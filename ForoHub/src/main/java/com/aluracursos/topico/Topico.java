package com.aluracursos.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Table(name = "topico")
@Entity(name = "topicos")
@EqualsAndHashCode(of = "id")

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean status;
    private String autor;
    private String curso;
    private Long respuesta;

    public Topico(){}

    public Topico( DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = true;
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Long getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Long respuesta) {
        this.respuesta = respuesta;
    }

    public void actualizarTopico (DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();

        }

        if(datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();

        }

        if(datosActualizarTopico.curso()!=null){
            this.curso = datosActualizarTopico.curso();

        }
        this.fechaCreacion=LocalDateTime.now();
    }


}
