package br.com.alfa.trabalho.view.controleAcesso;

import br.com.alfa.trabalho.constants.TipoPessoa;
import br.com.alfa.trabalho.model.Perfil;
import br.com.alfa.trabalho.model.PessoaFisica;
import br.com.alfa.trabalho.model.PessoaJuridica;
import br.com.alfa.trabalho.model.Usuario;
import br.com.alfa.trabalho.service.PerfilService;
import br.com.alfa.trabalho.service.UsuarioService;
import br.com.alfa.trabalho.view.comum.BaseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.List;

@Controller
@Scope("view")
@ManagedBean
public class UsuarioView extends BaseView {

    private static final long serialVersionUID = 1L;

    @Autowired
    private UsuarioService service;
    @Autowired
    private PerfilService perfilService;

    private List<Perfil> listaPerfil;
    private List<Usuario> lista;
    private Usuario entidade;
    private TipoPessoa tipoPessoa;

    private String senhaAtual;
    private String novaSenha;

    private String novoEmail;
    private String confirmacaoNovoEmail;

    @PostConstruct
    public void init() {
        try {
            listaPerfil = perfilService.listarTodosPerfisAtivos();
        } catch (Exception e) {
            addMessageERROR("Falha ao listar Perfis.");
        }
        try {
            lista = service.listarTodos();
        } catch (Exception e) {
            addMessageERROR("Falha ao listar Usuários.");
        }
    }

    public void remover() {
        if (entidade != null && entidade.getId() > 0L) {
            lista.remove(entidade);
        }
    }

    public void prepararNovo() {
        entidade = new Usuario();
        entidade.setPerfil(new Perfil());
        tipoPessoa = TipoPessoa.FISICA;
        cleanPessoa();
    }

    public void cleanPessoa() {
        if (tipoPessoa == TipoPessoa.FISICA) {
            entidade.setPessoa(new PessoaFisica());
        } else {
            entidade.setPessoa(new PessoaJuridica());
        }
    }

    public void detalharUsuario() {
        if (entidade.getPessoa() instanceof PessoaFisica) {
            tipoPessoa = TipoPessoa.FISICA;
        } else {
            tipoPessoa = TipoPessoa.JURIDICA;
        }
    }

    public void adicionar(){
        if (entidade != null) {
            entidade.setId(lista.size()+1L);
            lista.add(entidade);
        }
    }

    public void redefinirSenha() {
        Usuario u = getUsuarioLogado();

        if (novaSenha.length() < 6) {
            addMessageWARN("Sua senha deve possuir 6 a 10 caracteres.");
            setErrorMasterDetail(true);
            return;
        }
        if (!u.getSenha().equals(senhaAtual)) {
            addMessageWARN("Senha Atual incorreta.");
            setErrorMasterDetail(true);
            return;
        }

        u.setSenha(novaSenha);
        //TODO atualizar
    }


    public List<Perfil> getListaPerfil() {
        return listaPerfil;
    }

    public void setListaPerfil(List<Perfil> listaPerfil) {
        this.listaPerfil = listaPerfil;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }


    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getNovoEmail() {
        return novoEmail;
    }

    public void setNovoEmail(String novoEmail) {
        this.novoEmail = novoEmail;
    }

    public String getConfirmacaoNovoEmail() {
        return confirmacaoNovoEmail;
    }

    public void setConfirmacaoNovoEmail(String confirmacaoNovoEmail) {
        this.confirmacaoNovoEmail = confirmacaoNovoEmail;
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public Usuario getEntidade() {
        return entidade;
    }

    public void setEntidade(Usuario entidade) {
        this.entidade = entidade;
    }
}