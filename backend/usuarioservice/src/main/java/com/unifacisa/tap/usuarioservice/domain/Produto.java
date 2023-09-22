package com.unifacisa.tap.usuarioservice.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "produto")
public class Produto {
    private static final long serialVersionUID = 2134812446083923546L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private Double preco;

}

