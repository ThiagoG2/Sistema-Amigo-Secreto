package br.ufrpe.amigo_secreto.business.beans;

public class AmigoSecretoSorteado {
	private Pessoa darPresente;
	private Pessoa recebePresente;

	public AmigoSecretoSorteado(Pessoa darPresente, Pessoa recebePresente) {
		this.darPresente = darPresente;
		this.recebePresente = recebePresente;
	}

	public Pessoa getDarPresente() {
		return darPresente;
	}

	public void setDarPresente(Pessoa darPresente) {
		this.darPresente = darPresente;
	}

	public Pessoa getRecebePresente() {
		return recebePresente;
	}

	public void setRecebePresente(Pessoa recebePresente) {
		this.recebePresente = recebePresente;
	}

	@Override
	public String toString() {
		return "AmigoSecretoSorteado [darPresente=" + darPresente + ", recebePresente=" + recebePresente + "]";
	}
}
