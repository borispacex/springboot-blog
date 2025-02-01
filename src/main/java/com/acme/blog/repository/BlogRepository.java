package com.acme.blog.repository;

import com.acme.blog.model.Blog;
import com.acme.blog.model.enums.Estado;
import com.acme.blog.model.enums.Periocidad;
import jdk.jfr.Registered;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BlogRepository {

    private List<Blog> list = new ArrayList<Blog>();

    public void createProducts() {
        list = List.of(
                new Blog(1, false, "Titulo", "Tema", "Contenido", Periocidad.DIARIA)
        );
    }

    public List<Blog> obtenerBlogs() {
        return list;
    }

    public List<Blog> obtenerBlogsNoEliminados() {
        return list.stream().filter(x -> x.getEstado().equals(Estado.NO_ELIMINADO)).collect(Collectors.toList());
    }

    public Blog buscarPorId(int id){
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getIdBlog() == (id) && list.get(i).getEstado() == Estado.NO_ELIMINADO) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Blog> buscar(String titulo) {
        return list.stream().filter(x -> x.getTitulo().startsWith(titulo) && x.getEstado().equals(Estado.NO_ELIMINADO)).collect(Collectors.toList());
    }

    public Blog guardar(Blog b) {
        Blog blog = new Blog();
        blog.setIdBlog(b.getIdBlog());
        blog.setComentarios(b.getComentarios());
        blog.setTitulo(b.getTitulo());
        blog.setTema(b.getTema());
        blog.setContenido(b.getContenido());
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
        Blog blog = buscarPorId(id);
        blog.setEstado(Estado.ELIMINADO);
        list.set(idx, blog);
        return null;
    }

    public Blog actualizar(Blog b) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdBlog() == (b.getIdBlog())) {
                id = b.getIdBlog();
                idx = i;
                break;
            }
        }

        Blog blog = new Blog();
        blog.setIdBlog(b.getIdBlog());
        blog.setComentarios(b.getComentarios());
        blog.setTitulo(b.getTitulo());
        blog.setTema(b.getTema());
        blog.setContenido(b.getContenido());
        list.set(idx, blog);
        return blog;
    }

}
