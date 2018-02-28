package br.ufrpe.amigo_secreto.business;

import java.util.List;

import br.ufrpe.amigo_secreto.business.beans.AmigoSecretoSorteado;
import br.ufrpe.amigo_secreto.business.beans.Grupo;
import br.ufrpe.amigo_secreto.business.beans.Pessoa;
import br.ufrpe.amigo_secreto.business.beans.Presente;
import br.ufrpe.amigo_secreto.business.exception.GrupoExisteException;
import br.ufrpe.amigo_secreto.business.exception.PessoaExisteException;
import br.ufrpe.amigo_secreto.business.exception.PoucasPessoasNoGrupoException;
import br.ufrpe.amigo_secreto.business.exception.SorteioJaRealizadoException;

public interface IFachada {
	// Pessoa
	void cadastrarPessoa(Pessoa p) throws PessoaExisteException;
	Pessoa buscarPessoa(String apelido);
	List<Pessoa> listarPessoa();
	void removerPessoa(String apelido);
	void atualizar(Pessoa p);

	// Grupo
	void cadastrarGrupo(Grupo g) throws GrupoExisteException;
	Grupo buscarGrupo(String nomeGrupo);
	List<Grupo> listarGrupos();
	void removerGrupo(String nomeGrupo);
	List<AmigoSecretoSorteado> metodoDepurador(String nomeGrupo);

	// Presente
	void cadastrarPresente(Presente p);
	Presente buscarPresente(String categoria);
	List<Presente> listarPresentes();
	void removerPresente(String categoria);
	
	// Sorteio
	void gerarSorteio(String nomeGrupo) throws SorteioJaRealizadoException, PoucasPessoasNoGrupoException;
	Pessoa consultarAmigoSecreto(Grupo g, Pessoa p, String senha) throws SorteioJaRealizadoException;
	boolean existeSorteio(String nomeGrupo);
}
