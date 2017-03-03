package br.com.alfa.trabalho.model;

import br.com.alfa.trabalho.model.comum.AbstractModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Iagho
 */

public class Perfil extends AbstractModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private List<Permissao> listaPermissoes;
    private Date dataRegistro;
    private Date dataExclusao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public List<Permissao> getListaPermissoes() {
        return listaPermissoes;
    }

    public void setListaPermissoes(List<Permissao> listaPermissoes) {
        this.listaPermissoes = listaPermissoes;
    }
}