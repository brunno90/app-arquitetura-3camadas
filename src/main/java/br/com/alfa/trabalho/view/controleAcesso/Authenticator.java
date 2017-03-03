package br.com.alfa.trabalho.view.controleAcesso;

import br.com.alfa.trabalho.model.Usuario;
import br.com.alfa.trabalho.service.UsuarioService;
import br.com.alfa.trabalho.view.comum.BaseView;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
@Scope("view")
public class Authenticator extends BaseView {

    @Autowired
    private UsuarioService usuarioService;
    private String login;
    private String password;
    private Usuario usuario;

    public void login() {
        try {
            autenticar();
            loginSpringSecurity();
        } catch (Exception ex) {
            closeDialogs();
            addMessageERROR("Falha ao efetuar login! Contacte o administrador. - " + ex.getMessage());
        }
    }

    private void closeDialogs() {
        RequestContext.getCurrentInstance().execute("PF('statusBioDialog').hide(); PF('statusDialog').hide();");
    }


    private boolean autenticar() {
        return true;
    }

    private void loginSpringSecurity() throws IOException {

        redirecionar("index.xhtml");
    }

    public void logout() {
        getSession().setUsuario(null);
        redirecionar("/login.xhtml");
    }

    public void carregarPainelOpcoes() {
        redirecionar("painel/opcoes.xhtml");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}