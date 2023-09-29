package com.unifacisa.tap.usuarioservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "produto")
public class Produto implements Serializable {
    private static final long serialVersionUID = 3453453453453451L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private Double preco;

}

