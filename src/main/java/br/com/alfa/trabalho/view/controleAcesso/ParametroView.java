package br.com.alfa.trabalho.view.controleAcesso;

import br.com.alfa.trabalho.model.Parametro;
import br.com.alfa.trabalho.view.comum.BaseView;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("view")
public class ParametroView extends BaseView {

    private static final long serialVersionUID = 1L;
    private Parametro entidade;
    private List<Parametro> lista;

    public void init() {
    }

    public void prepararNovo() {
        entidade = new Parametro();
    }

    public Parametro getEntidade() {
        return entidade;
    }

    public void setEntidade(Parametro entidade) {
        this.entidade = entidade;
    }

    public List<Parametro> getLista() {
        return lista;
    }

    public void setLista(List<Parametro> lista) {
        this.lista = lista;
    }
}