package br.com.alfa.trabalho.model;

import br.com.alfa.trabalho.model.comum.AbstractModel;

import java.io.Serializable;

public class Endereco extends AbstractModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private Cidade cidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return logradouro + " " + complemento + " - Nº " + numero + " - " + bairro;
    }
}