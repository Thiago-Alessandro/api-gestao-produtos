package net.weg.apigestaoprodutos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE )
    private Integer id;
    @Column(unique = true)
    private String nome;
    @ManyToMany(mappedBy = "categorias")
    @JsonIgnore
    private Collection<Produto> produtos;

}
