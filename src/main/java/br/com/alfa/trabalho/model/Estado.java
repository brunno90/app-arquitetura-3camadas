package br.com.alfa.trabalho.model;

import br.com.alfa.trabalho.model.comum.AbstractModel;

import java.io.Serializable;

public class Estado extends AbstractModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String uf;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
