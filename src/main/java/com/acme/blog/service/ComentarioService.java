package com.acme.blog.service;

import com.acme.blog.dto.ComentarioRequest;
import com.acme.blog.dto.ComentarioResponse;
import com.acme.blog.model.Comentario;
import com.acme.blog.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public ComentarioResponse guardarComentario(ComentarioRequest comentario) {
        return comentarioRepository.guardar(comentario);
    }

    public List<ComentarioResponse> obtenerComentarios() {
        return comentarioRepository.obtenerComentarios();
    }

    public List<ComentarioResponse> obtenerComentariosNoEliminados() {
        return comentarioRepository.obtenerComentariosNoEliminados();
    }

    public ComentarioResponse buscarComentarioPorId(int id) {
        return comentarioRepository.buscarPorId(id);
    }

    public String eliminar(int id) {
        comentarioRepository.eliminar(id);
        return "Comentario eliminado !! " + id;
    }

    public ComentarioResponse actualizarComentario(Comentario comentario) {
        return comentarioRepository.actualizar(comentario);
    }

}
