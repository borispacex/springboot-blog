package com.acme.blog.repository;

import com.acme.blog.dto.BlogRequest;
import com.acme.blog.dto.BlogResponse;
import com.acme.blog.dto.ComentarioResponse;
import com.acme.blog.model.Autor;
import com.acme.blog.model.Blog;
import com.acme.blog.model.Comentario;
import com.acme.blog.model.enums.Estado;
import com.acme.blog.model.enums.Periocidad;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class BlogRepository {

    private List<BlogResponse> list = new ArrayList<BlogResponse>();

    @Autowired
    AutorRepository autorRepository;

    public List<BlogResponse> obtenerBlogs() {
        return list;
    }

    public List<BlogResponse> obtenerBlogsNoEliminados() {
        return list.stream().filter(x -> x.getEstado().equals(Estado.NO_ELIMINADO)).collect(Collectors.toList());
    }

    public BlogResponse agregarComentario(Integer id, ComentarioResponse comentario) {
        BlogResponse blog = buscarPorId(id);
        if(Objects.isNull(blog)) return null;
        List<ComentarioResponse> listaComentarios = blog.getListaComentarios();
        listaComentarios.add(comentario);

        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdBlog() == id) {
                idx = i;
                break;
            }
        }
        list.set(idx, blog);

        return blog;
    }

    public BlogResponse buscarPorId(int id){
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getIdBlog() == (id) && list.get(i).getEstado() == Estado.NO_ELIMINADO) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<BlogResponse> buscar(String titulo) {
        return list.stream().filter(x -> x.getTitulo().startsWith(titulo) && x.getEstado().equals(Estado.NO_ELIMINADO)).collect(Collectors.toList());
    }

    public BlogResponse guardar(BlogRequest b) {
        BlogResponse blogBuscar = buscarPorId(b.getIdBlog());
        if (!Objects.isNull(blogBuscar)) return null; // Si el idBlog ya existe

        Autor autor = autorRepository.buscarPorId(b.getIdAutor());
        if (Objects.isNull(autor)) return null; // Si el autor no existe

        BlogResponse blog = new BlogResponse();
        blog.setAutor(autor);
        blog.setListaComentarios(new ArrayList<ComentarioResponse>());
        blog.setIdBlog(b.getIdBlog());
        blog.setComentarios(b.getComentarios());
        blog.setTitulo(b.getTitulo());
        blog.setTema(b.getTema());
        blog.setContenido(b.getContenido());
        blog.setPeriocidad(b.getPeriocidad());
        blog.setEstado(Estado.NO_ELIMINADO);
        list.add(blog);
        return blog;
    }

    public String eliminar(Integer id) {
        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdBlog() == id) {
                idx = i;
                break;
            }
        }
        BlogResponse blog = buscarPorId(id);
        blog.setEstado(Estado.ELIMINADO);
        list.set(idx, blog);
        return null;
    }

    public BlogResponse actualizar(Blog b) {
        BlogResponse blog = buscarPorId(b.getIdBlog());
        if (Objects.isNull(blog)) return null; // No existe el blog

        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdBlog() == (b.getIdBlog())) {
                idx = i;
                break;
            }
        }

        blog.setIdBlog(b.getIdBlog());
        blog.setComentarios(Objects.isNull(b.getComentarios()) ? blog.getComentarios() : b.getComentarios());
        blog.setTitulo(Objects.isNull(b.getTitulo()) ? blog.getTitulo() : b.getTitulo());
        blog.setTema(Objects.isNull(b.getTema()) ? blog.getTema() : b.getTema());
        blog.setContenido(Objects.isNull(b.getContenido()) ? blog.getContenido() : b.getContenido());
        blog.setPeriocidad(Objects.isNull(b.getPeriocidad()) ? blog.getPeriocidad() : b.getPeriocidad());
        list.set(idx, blog);
        return blog;
    }

    public BlogResponse buscarPorIdAutor(int idAutor){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAutor().getIdAutor() == (idAutor) && list.get(i).getEstado() == Estado.NO_ELIMINADO) {
                return list.get(i);
            }
        }
        return null;
    }

}
