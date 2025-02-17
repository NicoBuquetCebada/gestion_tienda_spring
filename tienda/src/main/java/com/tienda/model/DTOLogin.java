package com.tienda.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DTOLogin {

    @Size(max = 50)
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Error de formato")
    private String nickname;

    @NotNull
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[.,+\\-!¡?¿])[A-Za-z0-9.,+\\-!¡?¿]{8,30}$", message = "Error de formato")
    private String password;

    public DTOLogin(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
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
