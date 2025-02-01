package com.acme.blog.dto;

import com.acme.blog.model.Blog;
import com.acme.blog.model.Comentario;
import com.acme.blog.model.Usuario;

public class ComentarioResponse extends Comentario {

    private Usuario usuario;
    private Integer idBlog;

    public ComentarioResponse() {}

    public ComentarioResponse(Integer idComentario, int puntuacion, String mensaje, Usuario usuario, Integer idBlog) {
        super(idComentario, puntuacion, mensaje);
        this.usuario = usuario;
        this.idBlog = idBlog;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }
}
