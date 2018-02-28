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

public class Fachada implements IFachada {
	private static Fachada instance;

	private CadastroPessoa cadastroPessoa;
	private CadastroGrupo cadastroGrupo;
	private CadastroPresente cadastroPresente;
	private CadastroSorteio cadastroSorteio;

	private Fachada() {
		this.cadastroPessoa = new CadastroPessoa();
		this.cadastroGrupo = new CadastroGrupo();
		this.cadastroPresente = new CadastroPresente();
		this.cadastroSorteio = new CadastroSorteio();
	}

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	@Override
	public void cadastrarPessoa(Pessoa p) throws PessoaExisteException {
		cadastroPessoa.cadastrar(p);

	}

	@Override
	public Pessoa buscarPessoa(String apelido) {
		return cadastroPessoa.buscar(apelido);
	}

	@Override
	public List<Pessoa> listarPessoa() {
		return cadastroPessoa.listarPessoas();
	}

	@Override
	public void removerPessoa(String apelido) {
		cadastroPessoa.remover(apelido);

	}

	@Override
	public void atualizar(Pessoa p) {
		cadastroPessoa.atualizar(p);

	}

	@Override
	public void cadastrarGrupo(Grupo g) throws GrupoExisteException {
		cadastroGrupo.cadastrar(g);
	}

	@Override
	public Grupo buscarGrupo(String nomeGrupo) {
		return cadastroGrupo.buscar(nomeGrupo);
	}

	@Override
	public List<Grupo> listarGrupos() {
		return cadastroGrupo.listarGrupos();
	}

	@Override
	public void removerGrupo(String nomeGrupo) {
		cadastroGrupo.remover(nomeGrupo);

	}

	@Override
	public List<AmigoSecretoSorteado> metodoDepurador(String nomeGrupo) {
		return cadastroGrupo.metodoDepurador(nomeGrupo);
	}

	@Override
	public void cadastrarPresente(Presente p) {
		cadastroPresente.cadastrar(p);
	}

	@Override
	public Presente buscarPresente(String categoria) {
		return cadastroPresente.buscar(categoria);
	}

	@Override
	public List<Presente> listarPresentes() {
		return cadastroPresente.listarPresentes();
	}

	@Override
	public void removerPresente(String categoria) {
		cadastroPresente.remover(categoria);
	}

	@Override
	public void gerarSorteio(String nomeGrupo) throws SorteioJaRealizadoException, PoucasPessoasNoGrupoException {
		cadastroSorteio.gerarSorteio(nomeGrupo);

	}

	@Override
	public Pessoa consultarAmigoSecreto(Grupo g, Pessoa p, String senha) throws SorteioJaRealizadoException {
		return cadastroSorteio.consultarAmigoSecreto(g, p, senha);
	}

	@Override
	public boolean existeSorteio(String nomeGrupo) {
		return cadastroSorteio.existeSorteio(nomeGrupo);
	}

}
