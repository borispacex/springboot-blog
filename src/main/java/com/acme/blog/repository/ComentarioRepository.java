package com.acme.blog.repository;

import com.acme.blog.dto.BlogResponse;
import com.acme.blog.dto.ComentarioRequest;
import com.acme.blog.dto.ComentarioResponse;
import com.acme.blog.model.Blog;
import com.acme.blog.model.Comentario;
import com.acme.blog.model.Usuario;
import com.acme.blog.model.enums.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class ComentarioRepository {

    private List<ComentarioResponse> list = new ArrayList<ComentarioResponse>();

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<ComentarioResponse> obtenerComentarios() {
        return list;
    }

    public List<ComentarioResponse> obtenerComentariosNoEliminados() {
        return list.stream().filter(x -> x.getEstado().equals(Estado.NO_ELIMINADO)).collect(Collectors.toList());
    }

    public ComentarioResponse buscarPorId(int id){
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getIdComentario() == (id) && list.get(i).getEstado() == Estado.NO_ELIMINADO) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<ComentarioResponse> buscar(String mensaje) {
        return list.stream().filter(x -> x.getMensaje().startsWith(mensaje) && x.getEstado().equals(Estado.NO_ELIMINADO)).collect(Collectors.toList());
    }

    public ComentarioResponse guardar(ComentarioRequest c) {
        Usuario usuario = usuarioRepository.buscarPorId(c.getIdUsuario());
        if (Objects.isNull(usuario)) return null; // Si el usuario no existe
        BlogResponse blog = blogRepository.buscarPorId(c.getIdBlog());
        if (Objects.isNull(blog)) return null; // Si el blog no existe
        if(!blog.getComentarios()) return null; // si el blog no permite comentarios
        if (!(c.getPuntuacion() >= 0 && c.getPuntuacion() <= 10)) return null; // solo permite puntuaciones de 0 a 10

        ComentarioResponse comentario = new ComentarioResponse();
        comentario.setUsuario(usuario);
        comentario.setIdBlog(blog.getIdBlog());
        comentario.setIdComentario(c.getIdComentario());
        comentario.setMensaje(c.getMensaje());
        comentario.setPuntuacion(c.getPuntuacion());
        comentario.setEstado(Estado.NO_ELIMINADO);
        // actualizar blog con comentarios
        BlogResponse blogActualizar = blogRepository.agregarComentario(blog.getIdBlog(), comentario);
        list.add(comentario);
        return comentario;
    }

    public String eliminar(Integer id) {
        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdComentario() == id) {
                idx = i;
                break;
            }
        }
        ComentarioResponse comentario = buscarPorId(id);
        comentario.setEstado(Estado.ELIMINADO);
        list.set(idx, comentario);
        return null;
    }

    public ComentarioResponse actualizar(Comentario c) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdComentario() == (c.getIdComentario())) {
                id = c.getIdComentario();
                idx = i;
                break;
            }
        }

        ComentarioResponse comentario = new ComentarioResponse();
        comentario.setIdComentario(c.getIdComentario());
        comentario.setMensaje(c.getMensaje());
        comentario.setPuntuacion(c.getPuntuacion());
        list.set(idx, comentario);
        return comentario;
    }

    public ComentarioResponse buscarPorIdUsuario(int idUsuario){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsuario().getIdUsuario() == (idUsuario) && list.get(i).getEstado() == Estado.NO_ELIMINADO) {
                return list.get(i);
            }
        }
        return null;
    }

}
