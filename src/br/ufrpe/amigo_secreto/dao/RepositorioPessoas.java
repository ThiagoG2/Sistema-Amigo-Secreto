package br.ufrpe.amigo_secreto.dao;

import java.util.ArrayList;

import br.ufrpe.amigo_secreto.business.beans.Pessoa;

public class RepositorioPessoas {
	private ArrayList<Pessoa> pessoas;
	private static RepositorioPessoas instance;

	public static RepositorioPessoas getInstance() {
		if (instance == null) {
			instance = new RepositorioPessoas();
		}
		return instance;
	}

	private RepositorioPessoas() {
		this.pessoas = new ArrayList<Pessoa>();
	}

	public void cadastrar(Pessoa p) {
		this.pessoas.add(p);
	}

	public Pessoa buscar(String apelido) {
		Pessoa pessoaBuscada = null;
		if (existe(apelido)) {
			for (Pessoa p : pessoas) {
				if (apelido.equals(p.getApelido())) {
					pessoaBuscada = p;
				}
			}
		}
		return pessoaBuscada;
	}

	public ArrayList<Pessoa> listar() {

		return pessoas;
	}

	public void remover(String apelido) {
		for (int i = 0; i < pessoas.size(); i++) {
			if (this.pessoas.get(i).getApelido().equals(apelido)) {
				this.pessoas.remove(i);
			}
		}
	}

	public boolean existe(String apelido) {
		boolean existe = false;
		for (int i = 0; i < pessoas.size(); i++) {
			if (this.pessoas.get(i).getApelido().equals(apelido)) {
				existe = true;
			}
		}
		return existe;
	}

	public void atualizar(Pessoa p) {

		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).equals(p)) {
				pessoas.set(i, p);
			}
		}
	}

}
