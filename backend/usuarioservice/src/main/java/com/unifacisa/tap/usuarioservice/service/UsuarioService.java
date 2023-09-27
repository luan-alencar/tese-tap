package com.unifacisa.tap.usuarioservice.service;

import com.unifacisa.tap.usuarioservice.domain.Usuario;
import com.unifacisa.tap.usuarioservice.repository.UsuarioRepository;
import com.unifacisa.tap.usuarioservice.resource.UsuarioResource;
import com.unifacisa.tap.usuarioservice.service.dto.UsuarioDTO;
import com.unifacisa.tap.usuarioservice.service.mapper.UsuarioMapper;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @SneakyThrows
    public UsuarioDTO buscarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("O usuário não existe."));
        return usuarioMapper.INSTANCE.usuarioToDTO(usuario);
    }

    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(UsuarioMapper.INSTANCE::usuarioToDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO salvarUsuario(UsuarioDTO dto) {
        Usuario usuario = UsuarioMapper.INSTANCE.DTOtoUsuario(dto);
        usuario = usuarioRepository.save(usuario); // Salva o usuário e obtém o usuário com ID atribuído.

//        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioResource.class)
//                        .getUsuarioPorId(usuario.getId()))
//                .withSelfRel();
//        Link link = Link.of("https://localhost:8080/usuarios/{id}" + usuario.getId()).withSelfRel();

        return UsuarioMapper.INSTANCE.usuarioToDTO(usuario);
    }

    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
