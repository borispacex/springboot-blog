package com.acme.blog.controller;

import com.acme.blog.model.Autor;
import com.acme.blog.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public Autor agregarAutor(@RequestBody Autor autor) {
        return autorService.guardarAutor(autor);
    }

    @GetMapping
    public List<Autor> obtenerAutores() {
        return autorService.obtenerAutores();
    }

    @GetMapping("{id}")
    public Autor buscarAutorPorId(@PathVariable int id) {
        return autorService.buscarAutorPorId(id);
    }

    @PutMapping
    public Autor actualizarAutor(@RequestBody Autor autor) {
        return autorService.actualizarAutor(autor);
    }

    @DeleteMapping("{id}")
    public String eliminarAutor(@PathVariable int id) {
        return autorService.eliminarAutor(id);
    }

}
