package com.tienda.model;

// dto para la request de login
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DTOLogin {

    @Size(max = 50, min = 1, message = "el tamaño debe ser de 1 a 50 caracteres")
    @NotNull(message = "el campo no puede ser nulo")
    @Pattern(regexp = "^[A-Za-z0-9]*$", message = "solo puede contener caracteres alfanumericos")
    private String nickname;

    @Size(max = 30, min = 8, message = "el tamaño debe ser de 8 a 30 caracteres")
    @NotNull(message = "el campo no puede ser nulo")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[.,+\\-!¡?¿])[A-Za-z0-9.,+\\-!¡?¿]*$",
            message = "tiene que contener como minimo una mayuscula una minuscula y un caracter especial (.,+-!¡?¿)")
    private String password;

    public DTOLogin(String nickname, String password) {
        setNickname(nickname);
        setPassword(password);
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
}
