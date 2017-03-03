package br.com.alfa.trabalho.service.impl;

import br.com.alfa.trabalho.model.Endereco;
import br.com.alfa.trabalho.model.Perfil;
import br.com.alfa.trabalho.model.PessoaFisica;
import br.com.alfa.trabalho.model.Usuario;
import br.com.alfa.trabalho.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public boolean adicionar(Usuario usuario) {
        return true;
    }

    public List<Usuario> listarTodos() {
        List<Usuario> lista = new ArrayList<>();

        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);

        Perfil p = new Perfil();
        p.setId(1L);
        p.setNome("ADMINISTRADOR");
        usuario1.setPerfil(p);

        PessoaFisica pf = new PessoaFisica();
        pf.setId(1L);
        pf.setNome("Aluno teste");
        pf.setCpf("04432941231");
        pf.setEmail("usuario@gmail.com");
        pf.setEndereco(new Endereco());
        pf.setTelefone("984883837");
        pf.setDataRegistro(new Date());
        usuario1.setPessoa(pf);

        usuario1.setAtivo(true);
        usuario1.setSenha("12345");

        lista.add(usuario1);
        return lista;
    }

    @Override
    public void registrarLogAcesso(Usuario usuario) {

    }

    public void atualizar(Usuario entity) {

    }

    public void remover(Usuario entity) {

    }
}