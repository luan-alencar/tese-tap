package com.unifacisa.tap.restclientservice.resource;

import com.unifacisa.tap.restclientservice.RestclientserviceApplication;
import com.unifacisa.tap.restclientservice.domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
@RequestMapping("api/usuarios")
@RequiredArgsConstructor
public class UsuarioResource {

    private final RestClient restClient;

    @GetMapping("/restclient")
    public ResponseEntity<Void> create() {
        Usuario usuario = new Usuario();
        return RestclientserviceApplication.createRestClient().post()
                .uri("http://localhost:8082/api/usuarios")
                .contentType(APPLICATION_JSON)
                .body(usuario)
                .retrieve()
                .toBodilessEntity();
    }

}
