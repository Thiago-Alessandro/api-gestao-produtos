package net.weg.apigestaoprodutos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @Column(unique = true, nullable = false)
    private Long codigoDeBarras;

    @Column(nullable = false)
    private Double preco;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String dataValidade;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Integer produtosEmEstoque;
    @Column(nullable = false)
    private Double peso;
    @Column(nullable = false)
    private Double medida;
    @ManyToOne
//    @Column(nullable = false)
    private Fabricante fabricante;
    @Column(nullable = false)
    @ManyToMany
    private Collection<Categoria> categorias;

}
