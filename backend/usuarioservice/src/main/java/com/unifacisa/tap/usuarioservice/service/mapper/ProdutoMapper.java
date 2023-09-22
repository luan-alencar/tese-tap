package com.unifacisa.tap.usuarioservice.service.mapper;

import com.unifacisa.tap.usuarioservice.domain.Produto;
import com.unifacisa.tap.usuarioservice.service.dto.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    /**
     * INSTANCE é uma forma de referenciar a função de mapeamento produtoToDTO do nosso ProdutoMapper
     * O código ProdutoMapper INSTANCE cria uma instância do mapeador definido na interface ProdutoMapper.
     * Essa instância é armazenada na variável INSTANCE para ser usada posteriormente para realizar os mapeamentos.
     */
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    ProdutoDTO produtoToDTO(Produto produto);

    Produto dtoToProduto(ProdutoDTO dto);

}
