package com.acme.blog.service;

import com.acme.blog.model.Comentario;
import com.acme.blog.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public Comentario guardarComentario(Comentario comentario) {
        return comentarioRepository.guardar(comentario);
    }

    public List<Comentario> obtenerComentarios() {
        return comentarioRepository.obtenerComentarios();
    }

    public List<Comentario> obtenerComentariosNoEliminados() {
        return comentarioRepository.obtenerComentariosNoEliminados();
    }

    public Comentario buscarComentarioPorId(int id) {
        return comentarioRepository.buscarPorId(id);
    }

    public String eliminar(int id) {
        comentarioRepository.eliminar(id);
        return "Comentario eliminado !! " + id;
    }

    public Comentario actualizarComentario(Comentario comentario) {
        return comentarioRepository.actualizar(comentario);
    }

}
