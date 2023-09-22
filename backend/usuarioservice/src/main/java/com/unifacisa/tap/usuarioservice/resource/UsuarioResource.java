package com.unifacisa.tap.usuarioservice.resource;

import com.unifacisa.tap.usuarioservice.service.UsuarioService;
import com.unifacisa.tap.usuarioservice.service.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.unifacisa.tap.usuarioservice.utils.ConstantsUtils.USUARIOS_ENDPOINT;

@RestController
@RequiredArgsConstructor
@RequestMapping(USUARIOS_ENDPOINT)
public class UsuarioResource  {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();

        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioService.buscarUsuario(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuario = usuarioService.salvarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(dto));
    }
}
