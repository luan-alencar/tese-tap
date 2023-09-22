package com.unifacisa.tap.orderservice.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Usuario {
    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private boolean admin;
}
