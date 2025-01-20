package com.aluracursos.topico;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(
//titulo, mensaje, autor, curso
    @NotBlank
    @JsonAlias("titulo") String titulo,

    @NotBlank
    @JsonAlias("mensaje") String mensaje,

    @NotBlank
    @JsonAlias("autor") String autor,

    @NotBlank
    @JsonAlias("curso") String curso
) {
}
