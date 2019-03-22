package com.desafiorest.resource;

import com.desafiorest.exception.NotFoundException;
import com.desafiorest.model.Pessoa;
import com.desafiorest.repository.PessoaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@Api(value = "Livre API Rest Pessoa Endpoint")
public class PessoasResource {
    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoasResource(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "Encontrar todos os bancos de dados")
    public List<Pessoa> findAll() {
        return this.pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pessoa findById(@PathVariable(value = "id") Long id) {
        return this.pessoaRepository.findById(id).orElseThrow(() -> new NotFoundException("Pessoa", "id", id));
    }

    @PostMapping
    @ResponseBody
    public Pessoa create(@RequestBody Pessoa pessoa) {
        return this.pessoaRepository.save(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoa update(@PathVariable(value = "id") Long id, @RequestBody Pessoa newPessoa) {
        Pessoa pessoa = this.pessoaRepository.findById(id).orElseThrow(() -> new NotFoundException("Pessoa", "id", id));

        pessoa.setNome(newPessoa.getNome());
        pessoa.setSobrenome(newPessoa.getSobrenome());
        pessoa.setIdade(newPessoa.getIdade());
        pessoa.setGenero(newPessoa.getGenero());
        pessoa.setEndereco(newPessoa.getEndereco());
        pessoa.setAtivo(newPessoa.getAtivo());

        Pessoa updatePessoa = this.pessoaRepository.save(pessoa);
        return updatePessoa;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable(value = "id") Long id) {
        Pessoa pessoa = this.pessoaRepository.findById(id).orElseThrow(() -> new NotFoundException("Pessoa", "id", id));
        this.pessoaRepository.delete(pessoa);

        return ResponseEntity.ok().build();
    }
}
