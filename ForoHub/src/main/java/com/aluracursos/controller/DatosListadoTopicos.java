package com.aluracursos.controller;

import com.aluracursos.topico.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
Long id,
String titulo,
String mensaje,
LocalDateTime fecha,
Boolean estado,
String autor,
String curso
) {
    public DatosListadoTopicos (Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),topico.getFechaCreacion(),
                topico.getStatus(), topico.getAutor(),topico.getCurso());
    }
}
