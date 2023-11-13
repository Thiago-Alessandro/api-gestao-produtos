package net.weg.apigestaoprodutos.controller;

import lombok.AllArgsConstructor;
import net.weg.apigestaoprodutos.model.Fabricante;
import net.weg.apigestaoprodutos.model.dto.IDTO;
import net.weg.apigestaoprodutos.service.FabricanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/fabricante")
public class FabricanteCotroller implements IController<Fabricante, Integer>{

    private FabricanteService fabricanteService;

    @PostMapping()
    @Override
    public ResponseEntity<Fabricante> cadastrar(@RequestBody IDTO fabricante) {
        try {
            return new ResponseEntity<>(fabricanteService.cadastrar(fabricante),HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    @Override
    public ResponseEntity<Fabricante> editar(@RequestBody IDTO fabricante) {
        try {
            return new ResponseEntity<>(fabricanteService.editar(fabricante),HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity deletar(@PathVariable Integer id) {
        try {
            fabricanteService.deletar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Fabricante> buscarUm(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(fabricanteService.buscarUm(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<Collection<Fabricante>> buscarTodos() {
        try {
            return new ResponseEntity<>(fabricanteService.buscarTodos(), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
