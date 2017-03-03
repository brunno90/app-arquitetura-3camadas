package br.com.alfa.trabalho.view.controleAcesso;

import br.com.alfa.trabalho.model.Usuario;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("session")
public class UserSession implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario user) {
        this.usuario = user;
    }

    public boolean isLoggedIn() {
        return usuario != null;
    }
}