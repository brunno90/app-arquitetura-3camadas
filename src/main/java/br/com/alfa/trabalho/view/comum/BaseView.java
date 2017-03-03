package br.com.alfa.trabalho.view.comum;

import br.com.alfa.trabalho.model.Usuario;
import br.com.alfa.trabalho.view.controleAcesso.UserSession;
import org.springframework.beans.factory.annotation.Autowired;

import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public abstract class BaseView implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private UserSession session;
    private Boolean usuarioDesmonte;
    private boolean validacoesOk;

    public Map<String, String> getRequestParameterMap() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    }

    public void setErrorMasterDetail(Boolean b) {
        validacoesOk = !b;
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elContext = fc.getELContext();
        SelectLevelListener selectLevelListener;
        try {
            selectLevelListener = (SelectLevelListener) elContext.getELResolver().getValue(elContext, null,
                    "selectLevelListener");
            selectLevelListener.setErrorOccured(b);
        } catch (RuntimeException ex) {
            throw new FacesException(ex.getMessage(), ex);
        }
    }

    protected void addMessageINFO(String msg) {
        FacesContext.getCurrentInstance().addMessage(msg, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
    }

    protected void addMessageINFO(String msg, String detail) {
        FacesContext.getCurrentInstance().addMessage(msg, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, detail));
    }

    protected void addMessageWARN(String msg) {
        FacesContext.getCurrentInstance().addMessage(msg, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg));
    }

    protected void addMessageWARN(String msg, String detail) {
        FacesContext.getCurrentInstance().addMessage(msg, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, detail));
    }

    protected void addMessageERROR(String msg) {
        FacesContext.getCurrentInstance().addMessage(msg, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
    }

    protected void addMessageERROR(String msg, String detail) {
        FacesContext.getCurrentInstance().addMessage(msg, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, detail));
    }

    // TODO: colocar nome do arquivo de mensagens variavel para ser setado de
    // acordo com o Locale
    public String getMessage(String key) {
        final String MENSAGENS = "mensagens.mensagens";
        Locale ptBR = new Locale("pt", "BR");
        ResourceBundle text = ResourceBundle.getBundle(MENSAGENS, ptBR);
        return text.getString(key);
    }

    protected void redirecionar(String url) {
        try {
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect(
                            FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/pages/"
                                    + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserSession getSession() {
        return session;
    }

    public Usuario getUsuarioLogado() {
        return session.getUsuario();
    }

}