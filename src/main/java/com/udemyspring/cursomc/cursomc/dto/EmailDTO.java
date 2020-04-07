package com.udemyspring.cursomc.cursomc.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmailDTO {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    public String getEmail() {
        return email;
    }

    public EmailDTO(){}

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
}
