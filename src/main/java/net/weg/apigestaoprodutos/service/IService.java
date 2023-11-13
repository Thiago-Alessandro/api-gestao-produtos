package net.weg.apigestaoprodutos.service;

import net.weg.apigestaoprodutos.model.dto.IDTO;

import java.util.Collection;

public interface IService <T,ID>{

    T cadastrar(IDTO dto);
    T editar(IDTO dto);
    void deletar(ID id);
    Collection<T> buscarTodos();
    T buscarUm(ID id);

}
