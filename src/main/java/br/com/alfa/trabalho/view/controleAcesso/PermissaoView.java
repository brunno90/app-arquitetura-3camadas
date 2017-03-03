package br.com.alfa.trabalho.view.controleAcesso;

import br.com.alfa.trabalho.model.Permissao;
import br.com.alfa.trabalho.view.comum.BaseView;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("view")
public class PermissaoView extends BaseView {

    private static final long serialVersionUID = 1L;
    private Permissao entidade;
    private List<Permissao> lista;

    public void init() {

    }

    public void prepararNovo() {
        entidade = new Permissao();
    }

    public Permissao getEntidade() {
        return entidade;
    }

    public void setEntidade(Permissao entidade) {
        this.entidade = entidade;
    }

    public List<Permissao> getLista() {
        return lista;
    }

    public void setLista(List<Permissao> lista) {
        this.lista = lista;
    }
}