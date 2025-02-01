package com.acme.blog.controller;

import com.acme.blog.dto.BlogRequest;
import com.acme.blog.dto.BlogResponse;
import com.acme.blog.model.Blog;
import com.acme.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public BlogResponse agregarBlog(@RequestBody BlogRequest blog) {
        return blogService.guardarBlog(blog);
    }

    @GetMapping
    public List<BlogResponse> obtenerBlogsNoEliminados() {
        return blogService.obtenerBlogsNoEliminados();
    }

    @GetMapping("{id}")
    public Blog buscarBlogPorId(@PathVariable int id) {
        return blogService.buscarBlogPorId(id);
    }

    @PutMapping
    public Blog actualizarBlog(@RequestBody Blog blog) {
        return blogService.actualizarBlog(blog);
    }

    @DeleteMapping("{id}")
    public String eliminarBlog(@PathVariable int id) {
        return blogService.eliminar(id);
    }

}
