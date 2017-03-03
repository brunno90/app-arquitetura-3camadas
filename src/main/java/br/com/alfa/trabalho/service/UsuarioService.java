package br.com.alfa.trabalho.service;

import br.com.alfa.trabalho.model.Usuario;

import java.util.List;

public interface UsuarioService {

    boolean adicionar(Usuario usuario);

    List<Usuario> listarTodos();

    void registrarLogAcesso(Usuario usuario);

}