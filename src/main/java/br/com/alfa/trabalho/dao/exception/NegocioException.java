package br.com.alfa.trabalho.dao.exception;

public class NegocioException extends Exception {
	private static final long serialVersionUID = 1L;

	public NegocioException() {
		super("NegocioException");
	}

	public NegocioException(Exception exception) {
		super(exception);
	}

	public NegocioException(String msg, Exception exception) {
		super(msg, exception);
	}

	public NegocioException(String msg) {
		super(msg);
	}
}
