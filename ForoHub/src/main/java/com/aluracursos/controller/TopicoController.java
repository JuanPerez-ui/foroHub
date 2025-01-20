package com.aluracursos.controller;

import com.aluracursos.ValidacionException;
import com.aluracursos.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")

public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    //registrar topico
    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarMedico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder){
        Topico topicoDuplicado = topicoRepository.buscaTopicoRepetidoPorTituloYMensaje( datosRegistroTopico.titulo(),
                datosRegistroTopico.mensaje());
        if (topicoDuplicado != null){
            throw new ValidacionException("El topico ya se encuentra registrado");
        }

        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),
                topico.getMensaje(),topico.getCurso(), topico.getFechaCreacion());

        URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }


    //listar todos los tópicos
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listadoMedicos(Pageable paginacion){
        //Page<Medico> medicos = medicoRepository.findAll(paginacion);
        Page<Topico> topicos = topicoRepository.findByStatusTrue(paginacion);
        return ResponseEntity.ok(topicos.map(DatosListadoTopicos::new));
    }

    //Mostrar topico por Id
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopicoCompleto> retornaDatosTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);

        var datosTopico = new DatosRespuestaTopicoCompleto(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getStatus(),topico.getAutor(),topico.getCurso());
        return ResponseEntity.ok(datosTopico);
    }

    //actualizar topico
    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico (@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        if (topico == null)
        {
            throw new ValidacionException("El Id del topico ingresado es incorrecto o no existe");
        }
        topico.actualizarTopico (datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),
                topico.getMensaje(),topico.getCurso(), topico.getFechaCreacion()));
    }

    //Eliminar topico de la base de datos
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        if (topico == null){
            throw new ValidacionException("El Id ingresado es incorrecto o el topico ya esta eliminado");
        }
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }
}
