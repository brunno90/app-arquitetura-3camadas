package br.com.alfa.trabalho.service;

import br.com.alfa.trabalho.model.Perfil;

import java.util.List;

public interface PerfilService {

    List<Perfil> listarTodosPerfisAtivos();

    Perfil findPerfilByName(String name);

}