package br.com.projetopeu.exception;

public class ResourceIntegretyConstraintViolation extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceIntegretyConstraintViolation(Object id) {
		super("ID Duplicado " + id);
	}
}
