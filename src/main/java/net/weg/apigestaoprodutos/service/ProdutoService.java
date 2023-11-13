package net.weg.apigestaoprodutos.service;

import lombok.AllArgsConstructor;
import net.weg.apigestaoprodutos.exception.ElementAlreadyExistsException;
import net.weg.apigestaoprodutos.exception.InvalidDataException;
import net.weg.apigestaoprodutos.model.Produto;
import net.weg.apigestaoprodutos.model.dto.IDTO;
import net.weg.apigestaoprodutos.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ProdutoService implements IService<Produto, Integer>{

    private ProdutoRepository produtoRepository;

    private boolean validarProduto(Produto produto){

        if(produto != null && produto.getNome() != null && produto.getProdutosEmEstoque() != null && produto.getPreco() != null
                && produto.getCategorias() != null && produto.getCodigoDeBarras() != null && produto.getDataValidade() != null
                && produto.getFabricante() != null&& produto.getMedida() != null && produto.getPeso() != null
                && produto.getNome() != "" && produto.getPreco() >= 0 && produto.getProdutosEmEstoque() >= 0 && produto.getMedida() > 0){
            return true;
        }
        throw new InvalidDataException();
    }

    private boolean verificaProdutoExistePorCodigoDeBarras(Produto produto){
        return produtoRepository.existsByCodigoDeBarras(produto.getCodigoDeBarras());
    }

    @Override
    public Produto cadastrar(IDTO dto) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produto,dto);
        validarProduto(produto);
        if(verificaProdutoExistePorCodigoDeBarras(produto)){
            throw new ElementAlreadyExistsException();
        }
        return produtoRepository.save(produto);
    }

    @Override
    public Produto editar(IDTO dto) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produto,dto);
        validarProduto(produto);
        if(verificaProdutoExistePorCodigoDeBarras(produto)){
            throw new ElementAlreadyExistsException();
        }
        return produtoRepository.save(produto);
    }

    @Override
    public void deletar(Integer id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public Collection<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto buscarUm(Integer id) {
        Produto produto = produtoRepository.findById(id).get();
        if (verificaProdutoExistePorCodigoDeBarras(produto)){
            return produto;
        }
        throw new NoSuchElementException();
    }
}
