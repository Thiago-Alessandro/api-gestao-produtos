package net.weg.apigestaoprodutos.controller;

import lombok.AllArgsConstructor;
import net.weg.apigestaoprodutos.exception.InvalidDataException;
import net.weg.apigestaoprodutos.model.Categoria;
import net.weg.apigestaoprodutos.model.dto.CategoriaDTO;
import net.weg.apigestaoprodutos.model.dto.IDTO;
import net.weg.apigestaoprodutos.service.CategoriaService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController implements IController<Categoria, Integer>{

    private CategoriaService categoriaService;

    @PostMapping()
    @Override
    public ResponseEntity<Categoria> cadastrar(@RequestBody IDTO categoria) {
        try {
            return new ResponseEntity<>(categoriaService.cadastrar(categoria),HttpStatus.OK);
        } catch (InvalidDataException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (DuplicateKeyException e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    @Override
    public ResponseEntity<Categoria> editar(IDTO categoria) {
        try {
            return new ResponseEntity<>(categoriaService.editar(categoria),HttpStatus.OK);
        } catch (InvalidDataException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (DuplicateKeyException e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Categoria> deletar(@PathVariable Integer id) {

        try {
            categoriaService.deletar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Categoria> buscarUm(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(categoriaService.buscarUm(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    @Override
    public ResponseEntity<Collection<Categoria>> buscarTodos() {
        return new ResponseEntity<>(categoriaService.buscarTodos(), HttpStatus.OK);
    }

}


//        try {
//                return ResponseEntity.ok(carroService.buscarUm(id));
//                // return new ResponseEntity<>(carroService.buscarUm(id),HttpStatus.OK);
//                // return new ResponseEntity<>(carroService.buscarUm(id),200);
//                } catch (NoSuchElementException e) {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }