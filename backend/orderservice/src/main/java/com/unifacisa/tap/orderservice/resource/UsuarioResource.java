package com.unifacisa.tap.orderservice.resource;

import com.unifacisa.tap.orderservice.domain.Usuario;
import com.unifacisa.tap.orderservice.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/usuarios")
@RestController
public class UsuarioResource {

    private final UsuarioService service;

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorID(@PathVariable Long id) {
        return service.buscarPorID(id);
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }

    @PutMapping
    public Usuario editar(@RequestBody Usuario usuario){
        return this.salvar(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        this.service.deletar(id);
    }
}
