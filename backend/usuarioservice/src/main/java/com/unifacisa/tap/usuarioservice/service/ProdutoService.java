package com.unifacisa.tap.usuarioservice.service;

import com.unifacisa.tap.usuarioservice.domain.Produto;
import com.unifacisa.tap.usuarioservice.domain.Usuario;
import com.unifacisa.tap.usuarioservice.repository.ProdutoRepository;
import com.unifacisa.tap.usuarioservice.resource.ProdutoResource;
import com.unifacisa.tap.usuarioservice.service.dto.ProdutoDTO;
import com.unifacisa.tap.usuarioservice.service.mapper.ProdutoMapper;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public PagedModel<ProdutoDTO> listarProdutos() {
        int page = 1;
        int size = 3;
        Pageable pageable = PageRequest.of(1, 3);
        Page<Produto> produtoPage = produtoRepository.findAll(pageable);
        Page<ProdutoDTO> produtoDTOPage = produtoPage.map(ProdutoMapper.INSTANCE::produtoToDTO);

        PagedModel.PageMetadata metadata = new PagedModel.PageMetadata(produtoDTOPage.getNumberOfElements(), produtoDTOPage.getNumber(), produtoDTOPage.getTotalElements());
        PagedModel<ProdutoDTO> pagedModel = PagedModel.of(produtoDTOPage.getContent(), metadata);

        if (produtoDTOPage.hasPrevious()) {
            pagedModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProdutoResource.class).listarProdutos(page - 1, size)).withRel("previous"));
        }
        if (produtoDTOPage.hasNext()) {
            pagedModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProdutoResource.class).listarProdutos(page + 1, size)).withRel("next"));
        }
        return pagedModel;
    }

    @SneakyThrows
    public ProdutoDTO buscarProdutoPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));
        return ProdutoMapper.INSTANCE.produtoToDTO(produto);
    }

    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO) {
        Produto produto = ProdutoMapper.INSTANCE.dtoToProduto(produtoDTO);
        produtoRepository.save(produto);
        return ProdutoMapper.INSTANCE.produtoToDTO(produto);
    }

    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public String helloWorld() {
        return "Hello World!";
    }

}
