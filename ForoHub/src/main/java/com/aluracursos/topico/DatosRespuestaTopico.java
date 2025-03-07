package com.aluracursos.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
    Long id,
    String titulo,
    String mensaje,
    String curso,
    LocalDateTime fechaCreacion
) {
}
