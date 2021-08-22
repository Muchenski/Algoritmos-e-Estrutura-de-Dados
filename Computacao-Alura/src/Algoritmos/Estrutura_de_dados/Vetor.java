package Algoritmos.Estrutura_de_dados;

import java.util.Arrays;

import Algoritmos.entidades.Aluno;

public class Vetor {

	private Aluno[] alunos = new Aluno[100];

	int totalDeAlunos = 0;

	public Vetor() {
	}

	public void adicionar(Aluno aluno, int posicao) {
		this.garantirEspacos();
		if (!this.posicaoValidaAdicionar(posicao)) {
			throw new IllegalArgumentException("Posição inválida!");
		}
		for (int i = this.totalDeAlunos - 1; i >= posicao; i--) {
			this.alunos[i + 1] = this.alunos[i];
		}
		this.alunos[posicao] = aluno;
		this.totalDeAlunos++;
	}

	public void adicionar(Aluno aluno) {
		this.garantirEspacos();
		this.alunos[this.totalDeAlunos] = aluno;
		this.totalDeAlunos++;
	}

	public void remover(int posicao) {
		for (int i = posicao; i < this.totalDeAlunos - 1; i++) {
			this.alunos[i] = this.alunos[i + 1];
		}
		this.alunos[posicao] = null;
		this.totalDeAlunos--;
	}

	public Aluno obter(int posicao) {
		if (!this.posicaoValidaObter(posicao)) {
			throw new IllegalArgumentException("Posição inválida!");
		}
		return this.alunos[posicao];
	}

	public boolean contem(Aluno aluno) {
		for (int i = 0; i < this.totalDeAlunos; i++) {
			if (aluno.equals(this.alunos[i])) {
				return true;
			}
		}
		return false;
	}

	public int tamanho() {
		return this.totalDeAlunos;
	}

	private void garantirEspacos() {
		if (this.totalDeAlunos == this.alunos.length) {
			Aluno[] novoArray = new Aluno[this.alunos.length * 2];
			for (int i = 0; i < this.alunos.length; i++) {
				novoArray[i] = this.alunos[i];
			}
			this.alunos = novoArray;
		}
	}

	private boolean posicaoValidaObter(int posicao) {
		return posicao >= 0 && posicao < this.totalDeAlunos;
	}

	private boolean posicaoValidaAdicionar(int posicao) {
		return posicao >= 0 && posicao <= this.totalDeAlunos;
	}

	@Override
	public String toString() {
		return Arrays.toString(this.alunos);
	}
}
