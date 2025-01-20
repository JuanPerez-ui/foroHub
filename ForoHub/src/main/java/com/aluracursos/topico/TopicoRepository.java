package com.aluracursos.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico,Long> {

    Page<Topico> findByStatusTrue(Pageable paginacion);

    @Query(value = """
        SELECT * FROM topico t
        WHERE t.titulo = :titulo
        AND t.mensaje = :mensaje
        """, nativeQuery = true)
    Topico buscaTopicoRepetidoPorTituloYMensaje (String titulo, String mensaje);



}
