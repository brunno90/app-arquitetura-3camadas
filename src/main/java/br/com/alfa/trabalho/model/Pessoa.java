package br.com.alfa.trabalho.model;

import br.com.alfa.trabalho.model.comum.AbstractModel;

import java.io.Serializable;
import java.util.Date;

public abstract class Pessoa extends AbstractModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String email;
    private String telefone;
    private Endereco endereco;
    private Date dataRegistro;
    private Date dataExclusao;

    public Boolean getIsPj() {
        if (this instanceof PessoaJuridica)
            return true;
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Date getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}