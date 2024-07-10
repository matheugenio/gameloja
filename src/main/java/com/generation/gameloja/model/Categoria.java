package com.generation.gameloja.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo nome é obrigatório!")
    @Size(min = 2, max = 100, message = "O atributo nome deve ter no mínimo 05 e no máximo 100 caracteres")
    private String nome;

    @Size(min = 10, max = 500, message = "O atributo descrição deve ter no mínimo 10 e no máximo 100 caracteres")
    private String descricao;

    @OneToMany(fetch =  FetchType.LAZY, mappedBy = "categoria",cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("produto")
    private List<Produto> produto;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
}
