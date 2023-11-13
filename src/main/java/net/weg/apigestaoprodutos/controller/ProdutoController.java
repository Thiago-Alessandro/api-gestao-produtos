package net.weg.apigestaoprodutos.controller;

import lombok.AllArgsConstructor;
import net.weg.apigestaoprodutos.model.Produto;
import net.weg.apigestaoprodutos.model.dto.IDTO;
import net.weg.apigestaoprodutos.service.ProdutoService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/produto")
public class ProdutoController implements IController<Produto, Integer>{

    private ProdutoService produtoService;

    @PostMapping
    @Override
    public ResponseEntity<Produto> cadastrar(@RequestBody IDTO produto) {
        try {
            return new ResponseEntity<>(produtoService.cadastrar(produto), HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (DuplicateKeyException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    @Override
    public ResponseEntity<Produto> editar(@RequestBody IDTO produto) {
        try {
            return new ResponseEntity<>(produtoService.editar(produto), HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (DuplicateKeyException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity deletar(@PathVariable Integer id) {
        try {
            produtoService.deletar(id);
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (DuplicateKeyException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Produto> buscarUm(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(produtoService.buscarUm(id), HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (DuplicateKeyException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<Collection<Produto>> buscarTodos() {
        try {
            return new ResponseEntity<>(produtoService.buscarTodos(), HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (DuplicateKeyException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
