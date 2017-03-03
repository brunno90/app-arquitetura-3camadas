package br.com.alfa.trabalho.service;

import br.com.alfa.trabalho.model.Permissao;

import java.util.List;

public interface PermissaoService {

    public List<Permissao> listarTodasPermissoesAtivas();
}