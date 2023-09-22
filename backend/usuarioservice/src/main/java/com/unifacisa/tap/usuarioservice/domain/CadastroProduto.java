package com.unifacisa.tap.usuarioservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cadastro_produto")
public class CadastroProduto implements Serializable {
    private static final long serialVersionUID = -7638442993107805809L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto")
    private Produto produto;
}
