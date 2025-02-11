package com.generation.gameloja.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo nome é obrigatório!")
    @Size(min = 5, max = 100, message = "O atributo nome deve ter no mínimo 05 e no máximo 100 caracteres")
    private String nome;


    @Size(min = 10, max = 500, message = "O atributo descrição deve ter no mínimo 10 e no máximo 100 caracteres")
    private String descricao;

    @NotNull
    private float preco;

    private String plataforma;

    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  String getNome() {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao (String descricao) {
        this.descricao = descricao;
    }


    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
