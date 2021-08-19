package Algoritmos.entidades;

public class DadosBusca {

	private Integer indice;

	private Integer numeroDePassos;

	public DadosBusca() {
	}

	public DadosBusca(Integer indice, Integer numeroDePassos) {
		this.indice = indice;
		this.numeroDePassos = numeroDePassos;
	}

	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public Integer getNumeroDePassos() {
		return numeroDePassos;
	}

	public void setNumeroDePassos(Integer numeroDePassos) {
		this.numeroDePassos = numeroDePassos;
	}

	@Override
	public String toString() {
		return "DadosBusca [indice=" + indice + ", numeroDePassos=" + numeroDePassos + "]";
	}

}
