package br.ufrpe.amigo_secreto.business.beans;

public class Presente {
	private String categoria;
	private String descricao;
	private double preco;

	public Presente(String categoria, String descricao, double preco) {
		this.categoria = categoria;
		this.descricao = descricao;
		this.preco = preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Categoria: " + categoria + "; Descrição: " + descricao + "; Preço: " + preco;
	}

}
