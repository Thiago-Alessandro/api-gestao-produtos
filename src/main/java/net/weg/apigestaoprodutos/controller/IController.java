package net.weg.apigestaoprodutos.controller;

import net.weg.apigestaoprodutos.model.dto.IDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

public interface IController <T, ID>{

    ResponseEntity<T> cadastrar(IDTO obj);
    ResponseEntity<T> editar(IDTO obj);
    ResponseEntity deletar(ID id);
    ResponseEntity<T> buscarUm(ID id);
    ResponseEntity<Collection<T>> buscarTodos();

}
