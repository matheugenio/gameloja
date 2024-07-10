package com.generation.gameloja.repository;

import com.generation.gameloja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public List<Produto> findAllByPlataformaContainingIgnoreCase(@Param("plataforma") String plataforma);

}
