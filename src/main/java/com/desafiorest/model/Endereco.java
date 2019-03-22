package com.desafiorest.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
public class Endereco implements Serializable {
    @Size(max = 150)
    @Column(name = "logradouro")
    private String logradouro;

    @Size(max = 50)
    @Column(name = "numero")
    private String numero;

    @Size(max = 200)
    @Column(name = "complemento")
    private String complemento;

    @Size(max = 100)
    @Column(name = "bairro")
    private String bairro;

    @Size(max = 80)
    @Column(name = "cep")
    private String cep;

    @Size(max = 150)
    @Column(name = "cidade")
    private String cidade;

    @Size(max = 150)
    @Column(name = "estado")
    private String estado;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
