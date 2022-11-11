package br.com.projetopeu.exception;

import javax.security.auth.login.LoginException;

public class LogExceptions extends LoginException{
	
	private static final long serialVersionUID = 1L;

	public LogExceptions(String msg) {
		super(msg);
	}
}
