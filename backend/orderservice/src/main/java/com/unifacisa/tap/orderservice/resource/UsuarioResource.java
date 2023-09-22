package com.unifacisa.tap.orderservice.resource;

import com.unifacisa.tap.orderservice.domain.Usuario;
import com.unifacisa.tap.orderservice.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UsuarioResource {

    private final UsuarioService service;

    @GetMapping("/api/usuarios")
    public List<Usuario> listar() {
        return service.listar();
    }

    @GetMapping("/api/usuarios/{id}")
    public Usuario buscarPorID(@PathVariable Long id) {
        return service.buscarPorID(id);
    }
}
