package com.unifacisa.tap.usuarioservice.service;

import com.unifacisa.tap.usuarioservice.domain.Produto;
import com.unifacisa.tap.usuarioservice.repository.ProdutoRepository;
import com.unifacisa.tap.usuarioservice.service.dto.ProdutoDTO;
import com.unifacisa.tap.usuarioservice.service.mapper.ProdutoMapper;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(ProdutoMapper.INSTANCE::produtoToDTO)
                .collect(Collectors.toList());
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
