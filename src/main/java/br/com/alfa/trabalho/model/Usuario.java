package br.com.alfa.trabalho.model;

import br.com.alfa.trabalho.model.comum.AbstractModel;

public class Usuario extends AbstractModel {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String senha;
    private Pessoa pessoa;
    private Perfil perfil;
    private Boolean ativo;

    public String getFullName() {
        if (pessoa instanceof PessoaFisica)
            return ((PessoaFisica) pessoa).getNome();
        else if (pessoa instanceof PessoaJuridica)
            return ((PessoaJuridica) pessoa).getRazaoSocial();
        else
            return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}