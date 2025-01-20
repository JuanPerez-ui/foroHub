package com.aluracursos.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopicoCompleto(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean status,
        String autor,
        String curso
) {
}
