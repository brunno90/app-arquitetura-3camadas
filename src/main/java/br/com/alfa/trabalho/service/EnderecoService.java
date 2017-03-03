package br.com.alfa.trabalho.service;

import br.com.alfa.trabalho.model.Cidade;
import br.com.alfa.trabalho.model.Endereco;
import br.com.alfa.trabalho.model.Estado;

import java.util.List;

public interface EnderecoService {

    List<Estado> listarTodosEstados();

    List<Cidade> findCidadesByName(String name);

    List<Cidade> listarCidadesPorEstado(Estado estado);

    Endereco findEnderecoByCep(String cep);
}