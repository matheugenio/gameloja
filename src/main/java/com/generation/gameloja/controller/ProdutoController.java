package com.generation.gameloja.controller;

import jakarta.validation.Valid;
import com.generation.gameloja.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.generation.gameloja.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id){
        return produtoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/plataforma/{plataforma}")
    public ResponseEntity<List<Produto>>getByPlataforma(@PathVariable String plataforma) {
        return ResponseEntity.ok(produtoRepository.findAllByPlataformaContainingIgnoreCase(plataforma));
    }

    @PutMapping
    public ResponseEntity<Produto> put(@Valid @RequestBody Produto Produto) {
        return produtoRepository.findById(Produto.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.OK)
                        .body(produtoRepository.save(Produto)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Produto> post(@Valid @RequestBody Produto Produto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoRepository.save(Produto));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Produto> Produto = produtoRepository.findById(id);

        if(Produto.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        produtoRepository.deleteById(id);
    }
    
    
}
