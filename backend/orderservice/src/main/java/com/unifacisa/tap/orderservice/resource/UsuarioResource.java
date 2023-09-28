package com.unifacisa.tap.orderservice.resource;

import com.unifacisa.tap.orderservice.domain.Usuario;
import com.unifacisa.tap.orderservice.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.unifacisa.tap.orderservice.ConstantsUtils.BASE_URL_USUARIOS;
import static com.unifacisa.tap.orderservice.ConstantsUtils.BASE_URL_USUARIOS_ID;

@RequiredArgsConstructor
@RequestMapping("/api/usuarios")
@RestController
public class UsuarioResource {

    private final UsuarioService service;
    private final WebClient webClient;

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
    public Usuario editar(@RequestBody Usuario usuario) {
        return this.salvar(usuario);
    }

//    @DeleteMapping("/{id}")
//    public void deletar(@PathVariable Long id) {
//        this.service.deletar(id);
//    }

    @GetMapping("/webflux")
    public ResponseEntity<ResponseEntity<List<Usuario>>> createWebflx() {
        return webClient.get()
                .uri(BASE_URL_USUARIOS)
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, this::handleServerError)
                .toEntityList(Usuario.class)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .block();
    }

    @GetMapping("/webflux-create")
    public Mono<Usuario> createUser() {
        Usuario usuario = new Usuario();
        usuario.setNome("test post webfluex");
        usuario.setCpf("2452345234");
        usuario.setAdmin(false);
        usuario.setEmail("asdfasd@sdfgsdfg.com");

        return webClient.post()
                .uri(BASE_URL_USUARIOS)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(usuario))
                .retrieve()
                .bodyToMono(Usuario.class);
//                .onStatus(HttpStatus::is2xxSuccessful, this::handleServerError);

    }

    @GetMapping("/webflux-update")
    public Mono<Usuario> updateUser() {
        Usuario usuario = new Usuario();
        usuario.setNome("test post webfluex");
        usuario.setCpf("2452345234");
        usuario.setAdmin(false);
        usuario.setEmail("asdfasd@sdfgsdfg.com");

        return webClient.put()
                .uri(BASE_URL_USUARIOS)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(usuario))
                .retrieve()
                .bodyToMono(Usuario.class);
//                .onStatus(HttpStatus::is2xxSuccessful, this::handleServerError);

    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable Long id) {

        return webClient
                .delete()
                .uri(BASE_URL_USUARIOS_ID)
                .retrieve()
                .toEntity(Void.class);
//                .onStatus(HttpStatus::is2xxSuccessful, this::handleServerError);
    }

    private Mono<? extends Throwable> handleServerError(ClientResponse response) {
        return Mono.error(new RuntimeException("Erro no servidor"));
    }

}
