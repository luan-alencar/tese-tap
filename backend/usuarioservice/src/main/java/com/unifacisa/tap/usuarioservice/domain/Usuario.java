package com.unifacisa.tap.usuarioservice.domain;

import lombok.Data;
import org.springframework.hateoas.EntityModel;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table
public class Usuario extends EntityModel<Usuario> implements Serializable {
    private static final long serialVersionUID = 265281295653480184L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private boolean admin;

}