package br.ufrpe.amigo_secreto.dao;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.amigo_secreto.business.beans.Grupo;

public class RepositorioGrupos {
	private ArrayList<Grupo> grupos;
	private static RepositorioGrupos instance;

	public static RepositorioGrupos getInstance() {
		if (instance == null) {
			instance = new RepositorioGrupos();
		}
		return instance;
	}

	private RepositorioGrupos() {
		this.grupos = new ArrayList<Grupo>();
	}

	public void cadastrar(Grupo g) {
		grupos.add(g);
	}

	public void remover(String nomeGrupo) {
		for (int i = 0; i < grupos.size(); i++) {
			if (this.grupos.get(i).getNomeGrupo().equals(nomeGrupo)) {
				this.grupos.remove(i);
			}
		}
	}

	public Grupo buscar(String nomeGrupo) {
		Grupo grupoBuscado = null;
		if (existe(nomeGrupo)) {
			for (Grupo g : grupos) {
				if (nomeGrupo.equals(g.getNomeGrupo())) {
					grupoBuscado = g;
				}
			}
		}
		return grupoBuscado;
	}

	public List<Grupo> listar() {
		return grupos;
	}

	public boolean existe(String nomeGrupo) {
		boolean existe = false;
		for (int i = 0; i < grupos.size(); i++) {
			if (this.grupos.get(i).getNomeGrupo().equals(nomeGrupo)) {
				existe = true;
			}
		}
		return existe;
	}

}
