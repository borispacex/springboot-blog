package com.acme.blog.service;

import com.acme.blog.dto.BlogRequest;
import com.acme.blog.dto.BlogResponse;
import com.acme.blog.model.Blog;
import com.acme.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public BlogResponse guardarBlog(BlogRequest blog) {
        return blogRepository.guardar(blog);
    }

    public List<BlogResponse> obtenerBlogs() {
        return blogRepository.obtenerBlogs();
    }

    public List<BlogResponse> obtenerBlogsNoEliminados() {
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
