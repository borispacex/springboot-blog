package com.acme.blog.dto;

import com.acme.blog.model.Comentario;

public class ComentarioRequest extends Comentario {

    private Integer idUsuario;
    private Integer idBlog;

    public ComentarioRequest() {}

    public ComentarioRequest(Integer idComentario, int puntuacion, String mensaje, Integer idUsuario, Integer idBlog) {
        super(idComentario, puntuacion, mensaje);
        this.idUsuario = idUsuario;
        this.idBlog = idBlog;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }
}
