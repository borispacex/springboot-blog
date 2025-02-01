package com.acme.blog.repository;

import com.acme.blog.model.Comentario;
import com.acme.blog.model.enums.Estado;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ComentarioRepository {

    private List<Comentario> list = new ArrayList<Comentario>();

    public List<Comentario> obtenerComentarios() {
        return list;
    }

    public List<Comentario> obtenerComentariosNoEliminados() {
        return list.stream().filter(x -> x.getEstado().equals(Estado.NO_ELIMINADO)).collect(Collectors.toList());
    }

    public Comentario buscarPorId(int id){
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getIdComentario() == (id) && list.get(i).getEstado() == Estado.NO_ELIMINADO) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Comentario> buscar(String mensaje) {
        return list.stream().filter(x -> x.getMensaje().startsWith(mensaje) && x.getEstado().equals(Estado.NO_ELIMINADO)).collect(Collectors.toList());
    }

    public Comentario guardar(Comentario c) {
        Comentario comentario = new Comentario();
        comentario.setIdComentario(c.getIdComentario());
        comentario.setMensaje(c.getMensaje());
        comentario.setPuntuacion(c.getPuntuacion());
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
        Comentario comentario = buscarPorId(id);
        comentario.setEstado(Estado.ELIMINADO);
        list.set(idx, comentario);
        return null;
    }

    public Comentario actualizar(Comentario c) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdComentario() == (c.getIdComentario())) {
                id = c.getIdComentario();
                idx = i;
                break;
            }
        }

        Comentario comentario = new Comentario();
        comentario.setIdComentario(c.getIdComentario());
        comentario.setMensaje(c.getMensaje());
        comentario.setPuntuacion(c.getPuntuacion());
        list.set(idx, comentario);
        return comentario;
    }

}
