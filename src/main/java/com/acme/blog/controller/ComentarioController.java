package com.acme.blog.controller;

import com.acme.blog.dto.ComentarioRequest;
import com.acme.blog.dto.ComentarioResponse;
import com.acme.blog.model.Comentario;
import com.acme.blog.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public Comentario agregarComentario(@RequestBody ComentarioRequest comentario) {
        return comentarioService.guardarComentario(comentario);
    }

    @GetMapping
    public List<ComentarioResponse> obtenerComentariosNoEliminados() {
        return comentarioService.obtenerComentariosNoEliminados();
    }

    @GetMapping("{id}")
    public Comentario buscarComentarioPorId(@PathVariable int id) {
        return comentarioService.buscarComentarioPorId(id);
    }

    @PutMapping
    public Comentario actualizarComentario(@RequestBody Comentario comentario) {
        return comentarioService.actualizarComentario(comentario);
    }

    @DeleteMapping("{id}")
    public String eliminarComentario(@PathVariable int id) {
        return comentarioService.eliminar(id);
    }

}
