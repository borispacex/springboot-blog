package com.acme.blog.model;

import com.acme.blog.model.enums.Estado;

public class Comentario {

    private Integer idComentario;
    private int puntuacion;
    private String mensaje;
    private Estado estado;

    public Comentario() {}

    public Comentario(Integer idComentario, int puntuacion, String mensaje) {
        this.idComentario = idComentario;
        this.puntuacion = puntuacion;
        this.mensaje = mensaje;
        this.estado = Estado.NO_ELIMINADO;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
