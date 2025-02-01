package com.acme.blog.dto;

import com.acme.blog.model.Autor;
import com.acme.blog.model.Blog;
import com.acme.blog.model.Comentario;
import com.acme.blog.model.enums.Periocidad;

import java.util.List;

public class BlogResponse extends Blog {

    private Autor autor;
    private List<Comentario> listaComentarios;

    public BlogResponse() {}

    public BlogResponse(Integer idBlog, Boolean comentarios, String titulo, String tema, String contenido, Periocidad periocidad, Autor autor) {
        super(idBlog, comentarios, titulo, tema, contenido, periocidad);
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

}
