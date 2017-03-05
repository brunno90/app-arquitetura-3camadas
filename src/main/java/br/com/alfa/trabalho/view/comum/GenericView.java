package br.com.alfa.trabalho.view.comum;


import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public abstract class GenericView implements Serializable {


    public void setErrorMasterDetail(Boolean b) {
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

    public Date getCurrentTime() {
        return Calendar.getInstance().getTime();
    }

    public String getCurrentTimeZone() {
        return TimeZone.getDefault().getID();
    }

    public void addMessageINFO(String msg) {
        FacesContext.getCurrentInstance().addMessage(msg, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
    }

    public void addMessageINFO(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(summary,
                new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
    }

    public void addMessageERROR(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(summary,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
    }

    public void addMessageERROR(String msg) {
        FacesContext.getCurrentInstance().addMessage(msg, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
    }

    public void addMessageWARN(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(summary,
                new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail));
    }

    public void addMessageWARN(String msg) {
        FacesContext.getCurrentInstance().addMessage(msg, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg));
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

//    public void setSession(UserSession session) {
//        this.session = session;
//    }
//
//    public Usuario getUsuarioLogado() {
//        return session.getUsuario();
//    }
}
