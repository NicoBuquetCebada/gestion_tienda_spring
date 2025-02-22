package com.tienda.model;

// dto para la request de login
public class DTOLogin {
    private String nickname;
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
