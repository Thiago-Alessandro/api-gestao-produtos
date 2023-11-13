package net.weg.apigestaoprodutos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    private String descricao;
    @Column(unique = true)
    private Long cnpj;

}
