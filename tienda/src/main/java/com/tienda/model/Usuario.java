package com.tienda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 50)
    @Pattern(regexp = "^[A-Za-z]{3,50}$", message = "Error de formato")
    private String nombre;

    @Size(max = 50)
    @NotNull
    @Column(name = "apellido", nullable = false, length = 50)
    @Pattern(regexp = "^[A-Za-z]{3,50}$", message = "Error de formato")
    private String apellido;

    @Size(max = 50)
    @NotNull
    @Column(name = "nickname", nullable = false, length = 50)
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Error de formato")
    private String nickname;

    @NotNull
    @Column(name = "password", nullable = false)
    // (?=.*[]) comprueba si hay al menos 1 caracter del tipo entre corchetes
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[.,+\\-!¡?¿])[A-Za-z0-9.,+\\-!¡?¿]{8,30}$", message = "Error de formato")
    private String password;

    @Column(name = "telefono")
    @Pattern(regexp = "^[0-9]{9}$", message = "Error de formato")
    private Integer telefono;

    @Size(max = 100)
    @Column(name = "domicilio", length = 100)
    @Pattern(regexp = "^[A-Za-z0-9.\\- ]{5,100}$")
    private String domicilio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

}