package br.ufrpe.amigo_secreto.business.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Grupo {
	private String nomeGrupo;
	private LocalDate dataSorteio;
	private ArrayList<Pessoa> listaParticipantes;
	private List<AmigoSecretoSorteado> listaAmigoSecreto;

	public Grupo(String nomeGrupo, LocalDate dataSorteio) {
		this.nomeGrupo = nomeGrupo;
		this.dataSorteio = dataSorteio;
		this.listaParticipantes = new ArrayList<>();
		this.listaAmigoSecreto = new ArrayList<>();
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public LocalDate getDataSorteio() {
		return dataSorteio;
	}

	public void setDataSorteio(LocalDate dataSorteio) {
		this.dataSorteio = dataSorteio;
	}

	public ArrayList<Pessoa> getListaParticipantes() {
		return listaParticipantes;
	}

	public void setListaParticipantes(Pessoa listaParticipantes) {
		this.listaParticipantes.add(listaParticipantes);
	}

	public List<AmigoSecretoSorteado> getListaAmigoSecreto() {
		return listaAmigoSecreto;
	}

	public void setListaAmigoSecreto(List<AmigoSecretoSorteado> listaAmigoSecreto) {
		this.listaAmigoSecreto = listaAmigoSecreto;
	}

	@Override
	public String toString() {
		return this.getNomeGrupo();
	}

}
