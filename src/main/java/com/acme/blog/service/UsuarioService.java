package com.acme.blog.service;

import com.acme.blog.model.Usuario;
import com.acme.blog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.guardar(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.obtenerUsuarios();
    }

    public Usuario obtenerUsuarioPorId(int id) {
        return usuarioRepository.buscarPorId(id);
    }

    public String eliminarUsuario(int id) {
        usuarioRepository.eliminar(id);
        return "Usuario eliminado !! " + id;
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.actualizar(usuario);
    }

}
