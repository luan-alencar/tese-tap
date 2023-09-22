package com.unifacisa.tap.usuarioservice.repository;

import com.unifacisa.tap.usuarioservice.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
