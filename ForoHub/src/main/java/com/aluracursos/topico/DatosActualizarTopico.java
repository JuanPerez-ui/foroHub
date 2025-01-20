package com.aluracursos.topico;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(

        @NotNull
        @JsonAlias("id") Long id,

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
