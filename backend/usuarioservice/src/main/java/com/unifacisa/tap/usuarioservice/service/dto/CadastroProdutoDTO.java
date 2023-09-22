package com.unifacisa.tap.usuarioservice.service.dto;

import com.unifacisa.tap.usuarioservice.domain.Produto;
import com.unifacisa.tap.usuarioservice.domain.Usuario;
import lombok.Data;

@Data
public class CadastroProdutoDTO {

    private Long id;
    private UsuarioDTO usuario;
    private ProdutoDTO produto;
}
