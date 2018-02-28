package br.ufrpe.amigo_secreto.business.beans;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
	private String nomeCompleto;
	private String apelido;
	private String senha;
	private List<Presente> listaDePresentes = new ArrayList<>();

	public Pessoa(String nomeCompleto, String apelido, String senha) {
		this.nomeCompleto = nomeCompleto;
		this.apelido = apelido;
		this.senha = senha;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Presente> getListaDePresentes() {
		return listaDePresentes;
	}

	public void setListaDePresentes(Presente presente) {
		this.listaDePresentes.add(presente);
	}

	@Override
	public String toString() {
		return this.getApelido();
	}
}
