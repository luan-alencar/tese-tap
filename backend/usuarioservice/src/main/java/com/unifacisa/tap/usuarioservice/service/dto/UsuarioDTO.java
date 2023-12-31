package com.unifacisa.tap.usuarioservice.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class UsuarioDTO implements Serializable {

    private Long id;

    @NotNull(message = "CPF não pode ser nulo")
    private String cpf;

    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @NotNull(message = "Email não pode ser nulo")
    @Email(message = "Email Inválido")
    private String email;

    @NotNull(message = "Telefone não pode ser nulo")
    @NotBlank(message = "Coloque um telefone")
    private String telefone;

    @NotNull(message = "Data de nascimento não pode ser nulo")
    private LocalDate dataNascimento;

    private Boolean admin;

}
