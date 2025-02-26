package com.tienda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50, min = 3, message = "el tamaño debe ser de 3 a 50 caracteres")
    @NotNull(message = "el campo no puede ser nulo")
    @Pattern(regexp = "^[A-Za-z]*$", message = "solo puede conetener caracteres alfabeticos")
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 50, min = 3, message = "el tamaño debe ser de 3 a 50 caracteres")
    @NotNull(message = "el campo no puede ser nulo")
    @Pattern(regexp = "^[A-Za-z]*$", message = "solo puede conetener caracteres alfabeticos")
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Size(max = 50, min = 1, message = "el tamaño debe ser de 1 a 50 caracteres")
    @NotNull(message = "el campo no puede ser nulo")
    @Pattern(regexp = "^[A-Za-z0-9]*$", message = "solo puede contener caracteres alfanumericos")
    @Column(name = "nickname", nullable = false, length = 50)
    private String nickname;

    @Lob
    @NotNull(message = "el campo no puede ser nulo")
    @Column(name = "password", nullable = false)
    private String password;

    @Size(max = 9, min = 9, message = "el tamaño debe ser exactamente 9 caracteres")
    @Pattern(regexp = "^[69][0-9]*$", message ="tiene que empezar por 6 o 9 y solo puede contener numeros")
    @Column(name = "telefono", length = 15)
    private String telefono;
    @Size(max = 100, min = 5, message = "el tamaño debe ser de 5 a 100 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9.\\- ]*$", message = "solo puede contener caracteres alfanumericos y los caracteres especiales .-")
    @Column(name = "domicilio", length = 100)
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

}