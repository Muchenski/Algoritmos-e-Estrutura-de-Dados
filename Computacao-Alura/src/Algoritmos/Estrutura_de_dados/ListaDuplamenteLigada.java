package Algoritmos.Estrutura_de_dados;

public class ListaDuplamenteLigada {

	private Celula primeiraCelula = null;
	private Celula ultimaCelula = null;
	private int totalDeElementos = 0;

	public void adicionarNoComeco(Object elemento) {
		if (this.totalDeElementos == 0) {
			Celula novaCelula = new Celula(elemento, null, null);
			this.primeiraCelula = novaCelula;
			this.ultimaCelula = novaCelula;
		} else {
			Celula novaCelula = new Celula(elemento, null, this.primeiraCelula);
			this.primeiraCelula.setCelulaAnterior(novaCelula);
			this.primeiraCelula = novaCelula;
		}
		this.totalDeElementos++;
	}

	public void adicionarNoFim(Object elemento) {
		if (this.totalDeElementos == 0) {
			adicionarNoComeco(elemento);
		} else {
			Celula novaCelula = new Celula(elemento, this.ultimaCelula, null);
			this.ultimaCelula.setProximaCelula(novaCelula);
			this.ultimaCelula = novaCelula;
			this.totalDeElementos++;
		}
	}

	public void adicionar(Object elemento, int posicao) {
		if (this.totalDeElementos == 0 || posicao == 0) {
			adicionarNoComeco(elemento);
		} else if (posicao == this.totalDeElementos) {
			adicionarNoFim(elemento);
		} else {
			Celula celulaAnterior = obterCelula(posicao - 1);
			Celula proximaCelula = celulaAnterior.getProximaCelula();
			Celula novaCelula = new Celula(elemento, celulaAnterior, proximaCelula);
			celulaAnterior.setProximaCelula(novaCelula);
			proximaCelula.setCelulaAnterior(novaCelula);
			this.totalDeElementos++;
		}
	}

	public void remover(int posicao) {
		if (this.totalDeElementos == 0 || posicao == 0) {
			this.removerDoComeco();
		} else if (posicao == this.totalDeElementos - 1) {
			this.removerDoFim();
		} else {
			Celula celulaAnterior = this.obterCelula(posicao - 1);
			Celula atual = celulaAnterior.getProximaCelula();
			Celula proximaCelula = atual.getProximaCelula();
			celulaAnterior.setProximaCelula(proximaCelula);
			proximaCelula.setCelulaAnterior(celulaAnterior);
			this.totalDeElementos--;
		}
	}

	public void removerDoComeco() {
		if (this.totalDeElementos == 0) {
			throw new IllegalArgumentException("Lista vazia!");
		}

		this.primeiraCelula = this.primeiraCelula.getProximaCelula();
		this.totalDeElementos--;

		if (this.totalDeElementos == 0) {
			this.ultimaCelula = null;
		}
	}

	public void removerDoFim() {
		if (this.totalDeElementos <= 1) {
			this.removerDoComeco();
		} else {
			Celula penultimaCelula = this.ultimaCelula.getCelulaAnterior();
			penultimaCelula.setProximaCelula(null);
			this.ultimaCelula = penultimaCelula;
			this.totalDeElementos--;
		}
	}

	public Object obter(int posicao) {
		return this.obterCelula(posicao).getElemento();
	}

	public boolean contem(Object elemento) {
		Celula celulaAtual = this.primeiraCelula;
		while (celulaAtual != null) {
			if (celulaAtual.getElemento().equals(elemento)) {
				return true;
			}
			celulaAtual = celulaAtual.getProximaCelula();
		}
		return false;
	}

	private Celula obterCelula(int posicao) {
		if (!posicaoValidaObter(posicao)) {
			throw new IllegalArgumentException("Posição inválida!");
		}
		Celula celulaAtual = this.primeiraCelula;
		for (int i = 0; i < posicao; i++) {
			celulaAtual = celulaAtual.getProximaCelula();
		}
		return celulaAtual;
	}

	public int tamanho() {
		return this.totalDeElementos;
	}

	private boolean posicaoValidaObter(int posicao) {
		return posicao >= 0 && posicao < this.totalDeElementos;
	}

	@Override
	public String toString() {
		if (this.totalDeElementos == 0) {
			return "[]";
		}

		Celula celulaAtual = primeiraCelula;

		StringBuilder sb = new StringBuilder();
		sb.append("[");

		sb.append(celulaAtual.getElemento());
		celulaAtual = celulaAtual.getProximaCelula();
		for (int i = 1; i < this.totalDeElementos; i++) {
			sb.append(", " + celulaAtual.getElemento());
			celulaAtual = celulaAtual.getProximaCelula();
		}

		sb.append("]");
		return sb.toString();
	}

	private class Celula {

		private Object elemento;
		private Celula proximaCelula;
		private Celula celulaAnterior;

		public Celula(Object elemento, Celula celulaAnterior, Celula proximaCelula) {
			this.elemento = elemento;
			this.celulaAnterior = celulaAnterior;
			this.proximaCelula = proximaCelula;
		}

		public Celula getProximaCelula() {
			return proximaCelula;
		}

		public void setProximaCelula(Celula proximaCelula) {
			this.proximaCelula = proximaCelula;
		}

		public Celula getCelulaAnterior() {
			return celulaAnterior;
		}

		public void setCelulaAnterior(Celula celulaAnterior) {
			this.celulaAnterior = celulaAnterior;
		}

		public Object getElemento() {
			return elemento;
		}
	}
}
