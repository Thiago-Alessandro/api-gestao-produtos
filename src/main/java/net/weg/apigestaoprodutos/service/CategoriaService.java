package net.weg.apigestaoprodutos.service;

import lombok.AllArgsConstructor;
import net.weg.apigestaoprodutos.exception.InvalidDataException;
import net.weg.apigestaoprodutos.model.Categoria;
import net.weg.apigestaoprodutos.model.Produto;
import net.weg.apigestaoprodutos.model.dto.CategoriaDTO;
import net.weg.apigestaoprodutos.model.dto.IDTO;
import net.weg.apigestaoprodutos.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class CategoriaService implements IService<Categoria, Integer>{

    private CategoriaRepository categoriaRepository;

    private boolean validaNome(Categoria categoria){
        if(categoria.getNome() != null && categoria.getNome() != ""){
            return true;
        }
        throw new InvalidDataException();
    }

    @Override
    public Categoria cadastrar(IDTO dto) {
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(dto,categoria);
        validaNome(categoria);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria editar(IDTO dto) {
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(categoria, dto);
        validaNome(categoria);
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deletar(Integer id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public Collection<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarUm(Integer id) {
        return categoriaRepository.findById(id).get();
    }
}
