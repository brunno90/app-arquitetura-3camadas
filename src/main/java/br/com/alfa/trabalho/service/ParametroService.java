package br.com.alfa.trabalho.service;

import br.com.alfa.trabalho.model.Parametro;

import java.util.List;

public interface ParametroService {

    public List<Parametro> listarTodos();

    Parametro buscarParametroPorNome(String parametro);
}