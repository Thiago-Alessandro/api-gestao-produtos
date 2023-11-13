package net.weg.apigestaoprodutos.model.dto;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import net.weg.apigestaoprodutos.model.Categoria;
import net.weg.apigestaoprodutos.model.Fabricante;

import java.util.Collection;

public class ProdutoDTO implements IDTO{

    private Double preco;
    private String dataValidade;
    private String descricao;
    private Integer produtosEmEstoque;
    private Double peso;
    private Double medida;
    @ManyToOne
    private Fabricante fabricante;
    @ManyToMany
    private Collection<Categoria> categorias;

}
