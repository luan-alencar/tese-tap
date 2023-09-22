package com.unifacisa.tap.usuarioservice.resource;

import com.unifacisa.tap.usuarioservice.repository.ProdutoRepository;
import com.unifacisa.tap.usuarioservice.service.ProdutoService;
import com.unifacisa.tap.usuarioservice.service.dto.ProdutoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.unifacisa.tap.usuarioservice.utils.ConstantsUtils.PRODUTOS_ENDPOINT;

@RestController
@RequestMapping(PRODUTOS_ENDPOINT)
@RequiredArgsConstructor
public class ProdutoResource {

    private final ProdutoRepository produtoRepository;
    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        List<ProdutoDTO> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long id) {
        ProdutoDTO produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvarProduto(@RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO produtoSalvo = produtoService.salvarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<ProdutoDTO> atualizarProduto(
            @RequestBody ProdutoDTO produtoAtualizado) {
        return ResponseEntity.ok(produtoService.salvarProduto(produtoAtualizado));
    }

    @GetMapping
    @RequestMapping("/hello")
    public ResponseEntity<String> hellorWorld() {
        return ResponseEntity.ok(this.produtoService.helloWorld());
    }
}

