package com.acme.blog.service;

import com.acme.blog.model.Blog;
import com.acme.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Blog guardarBlog(Blog blog) {
        return blogRepository.guardar(blog);
    }

    public List<Blog> obtenerBlogs() {
        return blogRepository.obtenerBlogs();
    }

    public List<Blog> obtenerBlogsNoEliminados() {
        return blogRepository.obtenerBlogsNoEliminados();
    }

    public Blog buscarBlogPorId(int id) {
        return blogRepository.buscarPorId(id);
    }

    public String eliminar(int id) {
        blogRepository.eliminar(id);
        return "Blog eliminado !! " + id;
    }

    public Blog actualizarBlog(Blog blog) {
        return blogRepository.actualizar(blog);
    }

}
