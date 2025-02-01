package com.acme.blog.service;

import com.acme.blog.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acme.blog.model.Autor;

import java.util.List;


@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor guardarAutor(Autor autor) {
        return autorRepository.guardar(autor);
    }

    public List<Autor> obtenerAutores() {
        return autorRepository.obteneorAutores();
    }

    public Autor buscarAutorPorId(int id) {
        return autorRepository.buscarPorId(id);
    }

    public String eliminarAutor(int id) {
        autorRepository.eliminar(id);
        return "Autor eliminado !! " + id;
    }

    public Autor actualizarAutor(Autor autor) {
        return autorRepository.actualizar(autor);
    }


}
