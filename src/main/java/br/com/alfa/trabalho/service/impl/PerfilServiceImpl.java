package br.com.alfa.trabalho.service.impl;

import br.com.alfa.trabalho.model.Perfil;
import br.com.alfa.trabalho.service.PerfilService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PerfilServiceImpl implements PerfilService, Serializable {

    private static final long serialVersionUID = 1L;


    public void adicionar(Perfil perfil) {

    }

    public void atualizar(Perfil perfil) {

    }

    public void remover(Perfil perfil) {

    }

    public List<Perfil> listarTodosPerfisAtivos() {
        List<Perfil> lista = new ArrayList<>();

        Perfil p1 = new Perfil();
        p1.setId(1L);
        p1.setNome("ADMINISTRADOR");
        p1.setDataRegistro(new Date());

        Perfil p2 = new Perfil();
        p2.setId(2L);
        p2.setNome("OPERADOR");
        p2.setDataRegistro(new Date());

        Perfil p3 = new Perfil();
        p3.setId(3L);
        p3.setNome("SECRETARIA");
        p3.setDataRegistro(new Date());

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        return lista;
    }

    public Perfil findPerfilByName(String name) {
        return new Perfil();
    }
}