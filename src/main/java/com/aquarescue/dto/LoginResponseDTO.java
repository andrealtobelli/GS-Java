package com.aquarescue.dto;

import java.util.List;

public class LoginResponseDTO {
    private String token;
    private List<Long> comunidades;

    public LoginResponseDTO(String token, List<Long> comunidades) {
        this.token = token;
        this.comunidades = comunidades;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Long> getComunidades() {
        return comunidades;
    }

    public void setComunidades(List<Long> comunidades) {
        this.comunidades = comunidades;
    }
}