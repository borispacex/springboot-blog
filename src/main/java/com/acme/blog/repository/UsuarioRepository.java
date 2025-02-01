package com.acme.blog.repository;

import com.acme.blog.model.Autor;
import com.acme.blog.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class UsuarioRepository {

    private List<Usuario> list = new ArrayList<Usuario>();

    public void createProducts() {
        list = List.of(
                new Usuario(1, "Juan", "Perez", "Gonzales", "Peru", "juan@test.com")
        );
    }

    public List<Usuario> obtenerUsuarios() {
        return list;
    }

    public Usuario buscarPorId(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdUsuario() == (id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Usuario> buscar(String nombre) {
        return list.stream().filter(x -> x.getNombres().startsWith(nombre)).collect(Collectors.toList());
    }

    public Usuario guardar(Usuario u) {
        Usuario usuarioBuscar = buscarPorId(u.getIdUsuario());
        if (!Objects.isNull(usuarioBuscar)) return null;

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(u.getIdUsuario());
        usuario.setNombres(u.getNombres());
        usuario.setPaterno(u.getPaterno());
        usuario.setMaterno(u.getMaterno());
        usuario.setPais(u.getPais());
        usuario.setEmail(u.getEmail());
        list.add(usuario);
        return usuario;
    }

    public String eliminar(Integer id) {
        Usuario usuario = buscarPorId(id);
        if (Objects.isNull(usuario)) return "Usuario " + id + " no existe!!";
        list.removeIf(x -> x.getIdUsuario() == (id));
        return "Usuario " + id +" eliminado !!";
    }

    public Usuario actualizar(Usuario u) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdUsuario() == (u.getIdUsuario())) {
                id = u.getIdUsuario();
                idx = i;
                break;
            }
        }

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(u.getIdUsuario());
        usuario.setNombres(u.getNombres());
        usuario.setPaterno(u.getPaterno());
        usuario.setMaterno(u.getMaterno());
        usuario.setPais(u.getPais());
        usuario.setEmail(u.getEmail());
        list.set(idx, usuario);
        return usuario;
    }

}
