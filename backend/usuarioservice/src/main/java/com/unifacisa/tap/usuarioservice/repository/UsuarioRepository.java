package com.unifacisa.tap.usuarioservice.repository;

import com.unifacisa.tap.usuarioservice.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
