package br.ufrpe.amigo_secreto.business;

import java.util.List;

import br.ufrpe.amigo_secreto.business.beans.Pessoa;
import br.ufrpe.amigo_secreto.business.exception.PessoaExisteException;
import br.ufrpe.amigo_secreto.dao.RepositorioPessoas;

public class CadastroPessoa {
	private RepositorioPessoas repositorio;

	public CadastroPessoa() {
		this.repositorio = RepositorioPessoas.getInstance();
	}

	public void cadastrar(Pessoa p) throws PessoaExisteException {
			if (!this.existe(p.getApelido())) {
				this.repositorio.cadastrar(p);
			} else {
				throw new PessoaExisteException("Já existe um grupo cadastrado com esse nome!");
			}
		
	}

	public void remover(String apelido) {
		Pessoa p = this.repositorio.buscar(apelido);
		if (p != null && p.getApelido().equals(apelido)) {
			this.repositorio.remover(apelido);
		}
	}

	public List<Pessoa> listarPessoas() {
		return repositorio.listar();
	}

	public Pessoa buscar(String apelido) {
		return this.repositorio.buscar(apelido);
	}

	public boolean existe(String apelido) {
		return this.repositorio.existe(apelido);
	}
	public void atualizar(Pessoa usuario) {
		if(usuario != null && repositorio.existe(usuario.getApelido()))
		this.repositorio.atualizar(usuario);
	}

}
