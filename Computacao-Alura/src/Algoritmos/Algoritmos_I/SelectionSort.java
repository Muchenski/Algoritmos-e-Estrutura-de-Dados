package Algoritmos.Algoritmos_I;

import java.util.List;

import Algoritmos.entidades.Produto;

public class SelectionSort {

	public static void main(String[] args) {

		Produto p1 = new Produto("Lamborghini", 1000000.0);
		Produto p2 = new Produto("Jipe", 46000.0);
		Produto p3 = new Produto("Brasília", 16000.0);
		Produto p4 = new Produto("Smart", 46000.0);
		Produto p5 = new Produto("Ferrari", 1200000.0);
		Produto p6 = new Produto("Fusca", 17000.0);

		Produto[] produtos = { p1, p2, p3, p4, p5, p6 };

		List.of(selectionSort(produtos.length, produtos)).forEach(System.out::println);
	}

	public static Produto[] selectionSort(int quantidadeDeElementos, Produto... produtos) {
		int indiceInicio = 0;
		for (int indiceAtual = indiceInicio; indiceAtual < quantidadeDeElementos - 1; indiceAtual++) {
			int indiceDoMaisBarato = indiceDoMaisBarato(indiceAtual, quantidadeDeElementos, produtos);
			Produto maisBarato = produtos[indiceDoMaisBarato];
			Produto atual = produtos[indiceAtual];
			produtos[indiceDoMaisBarato] = atual;
			produtos[indiceAtual] = maisBarato;
		}
		return produtos;
	}

	public static int indiceDoMaisBarato(int indiceInicio, int quantidadeDeElementos, Produto... produtos) {
		if (indiceInicio < 0 || quantidadeDeElementos > produtos.length) {
			throw new IllegalArgumentException();
		}
		int indiceDoMaisBarato = indiceInicio;
		for (int indiceAtual = indiceInicio; indiceAtual < quantidadeDeElementos; indiceAtual++) {
			if (produtos[indiceDoMaisBarato].getValor() > produtos[indiceAtual].getValor()) {
				indiceDoMaisBarato = indiceAtual;
			}
		}
		return indiceDoMaisBarato;
	}
}
