package br.ufrpe.amigo_secreto.business.exception;

public class PessoaExisteException extends Exception{
	public PessoaExisteException(String mensagem) {
		super(mensagem);
	}
}
