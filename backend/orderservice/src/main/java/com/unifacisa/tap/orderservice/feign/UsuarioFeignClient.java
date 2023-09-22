package com.unifacisa.tap.orderservice.feign;

import com.unifacisa.tap.orderservice.domain.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "usuarioservice", url = "http://localhost:8080")
// Ajuste a URL para o endereço do serviço usuarioservice
public interface UsuarioFeignClient {

    @GetMapping("/api/usuarios/{id}")
    Usuario getUsuarioById(@PathVariable Long id);

    @GetMapping("/api/usuarios")
    List<Usuario> listar();
}
