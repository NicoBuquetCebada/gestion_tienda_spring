package com.tienda.model;

public class DTOUsuario {
    private String nombre;
    private String apellido;
    private String nickname;

    public DTOUsuario(String nombre, String apellido, String nickname) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
    }

    public DTOUsuario(Usuario usuario) {
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.nickname = usuario.getNickname();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
