package com.desafiorest.resource;

import com.desafiorest.exception.NotFoundException;
import com.desafiorest.model.Pessoas;
import com.desafiorest.repository.PessoaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@Api(value = "Livre API Rest Pessoas Endpoint")
public class PessoasResource {
    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoasResource(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "Encontrar todos os bancos de dados")
    public List<Pessoas> findAll() {
        return this.pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pessoas findById(@PathVariable(value = "id") Long id) {
        return this.pessoaRepository.findById(id).orElseThrow(() -> new NotFoundException("Pessoas", "id", id));
    }

    @PostMapping
    @ResponseBody
    public Pessoas create(@RequestBody Pessoas pessoas) {
        return this.pessoaRepository.save(pessoas);
    }

    @PutMapping("/{id}")
    public Pessoas update(@PathVariable(value = "id") Long id, @RequestBody Pessoas newPessoas) {
        Pessoas pessoas = this.pessoaRepository.findById(id).orElseThrow(() -> new NotFoundException("Pessoa", "id", id));

        pessoas.setNome(newPessoas.getNome());
        pessoas.setSobrenome(newPessoas.getSobrenome());
        pessoas.setIdade(newPessoas.getIdade());
        pessoas.setSexo(newPessoas.getSexo());

        Pessoas updatePessoas = this.pessoaRepository.save(pessoas);
        return updatePessoas;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable(value = "id") Long id) {
        Pessoas pessoas = this.pessoaRepository.findById(id).orElseThrow(() -> new NotFoundException("Pessoa", "id", id));
        this.pessoaRepository.delete(pessoas);

        return ResponseEntity.ok().build();
    }
}
