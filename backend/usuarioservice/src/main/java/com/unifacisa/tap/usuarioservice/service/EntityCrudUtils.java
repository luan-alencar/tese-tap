package com.unifacisa.tap.usuarioservice.service;

import java.util.List;

public interface EntityCrudUtils<D, E> {

    D buscar(Long id);

    List<D> listar();

    void salvar(D dto);

    void deletar(Long id);

    D atualizar(D dto);
}
