package com.desafiorest;

import com.desafiorest.model.Genero;
import com.desafiorest.model.Pessoa;
import com.desafiorest.repository.PessoaRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DesafiorestApplicationPessoaTest {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createPessoaTest() {
        Pessoa pessoa = new Pessoa("Thieles", null, "Martins", 31, Genero.MASCULINO, true);
        this.pessoaRepository.save(pessoa);
        assertThat(pessoa.getId()).isNotNull();
        assertThat(pessoa.getNome()).isEqualTo("Thieles");
        assertThat(pessoa.getEndereco()).isEqualTo(null);
        assertThat(pessoa.getSobrenome()).isEqualTo("Martins");
        assertThat(pessoa.getIdade()).isEqualTo(31);
        assertThat(pessoa.getGenero()).isEqualTo(Genero.MASCULINO);
        assertThat(pessoa.getAtivo()).isEqualTo(true);
    }

    @Test
    public void deletePessoaTest() {
        Pessoa pessoa = new Pessoa("Thieles", null, "Martins", 31, Genero.MASCULINO, true);
        this.pessoaRepository.save(pessoa);
        pessoaRepository.delete(pessoa);
    }
}
