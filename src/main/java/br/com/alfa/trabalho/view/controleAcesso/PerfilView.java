package br.com.alfa.trabalho.view.controleAcesso;

import br.com.alfa.trabalho.model.Perfil;
import br.com.alfa.trabalho.model.Permissao;
import br.com.alfa.trabalho.service.PerfilService;
import br.com.alfa.trabalho.service.PermissaoService;
import br.com.alfa.trabalho.view.comum.BaseView;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.List;

@Controller
@Scope("view")
@ManagedBean
public class PerfilView extends BaseView {

    private static final long serialVersionUID = 1L;
    private List<Perfil> lista;
    private Perfil entidade;

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private PermissaoService permissaoService;

    private DualListModel<Permissao> dualListPermissoes;

    @PostConstruct
    public void init() {
        lista = perfilService.listarTodosPerfisAtivos();
    }

    public void adicionar() {

    }

    public void atualizar() {

    }

    public void prepararNovo() {

    }

    public void detalharPerfil() {

    }

    public void remover() {
        lista.remove(entidade);
    }

    public List<Perfil> getLista() {
        return lista;
    }

    public void setLista(List<Perfil> lista) {
        this.lista = lista;
    }

    // GETS AND SETS
    public DualListModel<Permissao> getDualListPermissoes() {
        return dualListPermissoes;
    }

    public void setDualListPermissoes(DualListModel<Permissao> dualListPermissoes) {
        this.dualListPermissoes = dualListPermissoes;
    }

    public Perfil getEntidade() {
        return entidade;
    }

    public void setEntidade(Perfil entidade) {
        this.entidade = entidade;
    }
}