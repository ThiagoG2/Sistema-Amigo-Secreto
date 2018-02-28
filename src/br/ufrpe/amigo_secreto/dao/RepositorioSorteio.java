package br.ufrpe.amigo_secreto.dao;

import java.util.ArrayList;

import br.ufrpe.amigo_secreto.business.beans.Grupo;

public class RepositorioSorteio {
	private ArrayList<Grupo> gruposSorteados;
	private static RepositorioSorteio instance;

	public static RepositorioSorteio getInstance() {
		if (instance == null) {
			instance = new RepositorioSorteio();
		}
		return instance;
	}

	private RepositorioSorteio() {
		this.gruposSorteados = new ArrayList<Grupo>();
	}

	public void cadastrar(Grupo g) {
		gruposSorteados.add(g);
	}

	public void remover(String nomeGrupo) {
		for (int i = 0; i < gruposSorteados.size(); i++) {
			if (this.gruposSorteados.get(i).getNomeGrupo().equals(nomeGrupo)) {
				this.gruposSorteados.remove(i);
			}
		}
	}

	public boolean existe(String nomeGrupo) {
		boolean existe = false;
		for (int i = 0; i < gruposSorteados.size(); i++) {
			if (this.gruposSorteados.get(i).getNomeGrupo().equals(nomeGrupo)) {
				existe = true;
			}
		}
		return existe;
	}

}
