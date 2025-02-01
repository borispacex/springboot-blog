package com.acme.blog.repository;

import com.acme.blog.model.Autor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class AutorRepository {

    private List<Autor> list = new ArrayList<Autor>();

    public void crearAutores() {
        list = List.of(
                new Autor(1, "12-01-1996","Boris", "Vargas", "Paucara", "Bolivia", "borisvargaspaucara@gmail.com")
        );
    }

    public List<Autor> obteneorAutores() {
        return list;
    }

    public Autor buscarPorId(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdAutor() == (id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Autor> buscar(String nombre) {
        return list.stream().filter(x -> x.getNombres().startsWith(nombre)).collect(Collectors.toList());
    }

    public Autor guardar(Autor a) {
        Autor autorBuscar = buscarPorId(a.getIdAutor());
        if (!Objects.isNull(autorBuscar)) return null;

        Autor autor = new Autor();
        autor.setIdAutor(a.getIdAutor());
        autor.setNacimiento(a.getNacimiento());
        autor.setNombres(a.getNombres());
        autor.setPaterno(a.getPaterno());
        autor.setMaterno(a.getMaterno());
        autor.setPais(a.getPais());
        autor.setEmail(a.getEmail());
        list.add(autor);
        return autor;
    }

    public String eliminar(Integer id) {
        Autor autor = buscarPorId(id);
        if (Objects.isNull(autor)) return "Autor " + id + " no existe!!";
        list.removeIf(x -> x.getIdAutor() == (id));
        return "Autor " + id +" eliminado !!";
    }

    public Autor actualizar(Autor a) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdAutor() == (a.getIdAutor())) {
                id = a.getIdAutor();
                idx = i;
                break;
            }
        }

        Autor autor = new Autor();
        autor.setIdAutor(a.getIdAutor());
        autor.setNacimiento(a.getNacimiento());
        autor.setNombres(a.getNombres());
        autor.setPaterno(a.getPaterno());
        autor.setMaterno(a.getMaterno());
        autor.setPais(a.getPais());
        autor.setEmail(a.getEmail());
        list.set(idx, autor);
        return autor;
    }

}
