package br.com.alfa.trabalho.dao.exception;

public class ServicoException extends Exception {
	
    private static final long serialVersionUID = 1L;

    public ServicoException() {
        super("ServicoException");
    }

    public ServicoException(Exception exception) {
        super(exception);
    }
    
    public ServicoException(String msg, Exception exception) {
    	super(msg, exception);
    }
    
    public ServicoException(String msg) {
        super(msg);
    }
}