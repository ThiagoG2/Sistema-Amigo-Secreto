package br.ufrpe.amigo_secreto.dao;

import java.util.ArrayList;

import br.ufrpe.amigo_secreto.business.beans.Presente;

public class RepositorioPresentes {
	private ArrayList<Presente> presentes;
	private static RepositorioPresentes instance;

	public static RepositorioPresentes getInstance() {
		if (instance == null) {
			instance = new RepositorioPresentes();
		}
		return instance;
	}

	private RepositorioPresentes() {
		this.presentes = new ArrayList<Presente>();
	}

	public void cadastrar(Presente p) {
		presentes.add(p);
	}

	public Presente buscar(String categoria) {
		Presente presenteBuscado = null;
		if (existe(categoria)) {
			for (Presente p : presentes) {
				if (categoria.equals(p.getCategoria())) {
					presenteBuscado = p;
				}
			}
		}
		return presenteBuscado;
	}

	public ArrayList<Presente> listar() {

		return presentes;
	}

	public void remover(String categoria) {
		for (int i = 0; i < presentes.size(); i++) {
			if (this.presentes.get(i).getCategoria().equals(categoria)) {
				this.presentes.remove(i);
			}
		}
	}

	public boolean existe(String categoria) {
		boolean existe = false;
		for (int i = 0; i < presentes.size(); i++) {
			if (this.presentes.get(i).getCategoria().equals(categoria)) {
				existe = true;
			}
		}
		return existe;
	}

}
