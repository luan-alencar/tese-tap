package com.unifacisa.tap.orderservice.service;

import com.unifacisa.tap.orderservice.domain.Usuario;
import com.unifacisa.tap.orderservice.feign.UsuarioFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.unifacisa.tap.orderservice.ConstantsUtils.BASE_URL_USUARIOS;
import static com.unifacisa.tap.orderservice.ConstantsUtils.BASE_URL_USUARIOS_ID;

@Service
public class UsuarioService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UsuarioFeignClient usuarioFeignClient;

    @Autowired
    public UsuarioService(UsuarioFeignClient usuarioFeignClient) {
        this.usuarioFeignClient = usuarioFeignClient;
    }

    public List<Usuario> listar() {
        return restTemplate.getForObject(BASE_URL_USUARIOS, List.class);
    }

    public Usuario buscarPorID(Long id) {
        Map<String, Long> parametros = new HashMap<>();
        parametros.put("id", id);

        return restTemplate.getForObject(BASE_URL_USUARIOS_ID, Usuario.class, parametros);
    }

    public Usuario editar(Usuario usuario) {
        return this.salvar(usuario);
    }

    public Usuario salvar(Usuario usuario) {
        return restTemplate.postForObject(BASE_URL_USUARIOS, usuario, Usuario.class);
    }

    public void deletar(Long id) {
        Map<String, Long> parametros = new HashMap<>();
        parametros.put("id", id);

        restTemplate.delete(BASE_URL_USUARIOS_ID, parametros);
    }
}
