package com.acme.blog.dto;

import com.acme.blog.model.Blog;
import com.acme.blog.model.enums.Periocidad;

public class BlogRequest extends Blog {

    private Integer idAutor;

    public BlogRequest() {}

    public BlogRequest(Integer idBlog, Boolean comentarios, String titulo, String tema, String contenido, Periocidad periocidad, Integer idAutor) {
        super(idBlog, comentarios, titulo, tema, contenido, periocidad);
        this.idAutor = idAutor;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }
}
