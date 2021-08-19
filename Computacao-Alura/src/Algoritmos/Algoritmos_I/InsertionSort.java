package Algoritmos.Algoritmos_I;

import java.util.List;

import Algoritmos.entidades.Produto;

public class InsertionSort {

	public static void main(String[] args) {

		Produto p1 = new Produto("Lamborghini", 1000000.0);
		Produto p2 = new Produto("Jipe", 46000.0);
		Produto p3 = new Produto("Brasília", 16000.0);
		Produto p4 = new Produto("Smart", 46000.0);
		Produto p5 = new Produto("Ferrari", 1200000.0);
		Produto p6 = new Produto("Fusca", 17000.0);

		Produto[] produtos = { p1, p2, p3, p4, p5, p6 };

		List.of(insertionSort(produtos.length, produtos)).forEach(System.out::println);
	}

	public static Produto[] insertionSort(int quantidadeDeElementos, Produto... produtos) {
		for (int indiceAtual = 1; indiceAtual < quantidadeDeElementos; indiceAtual++) {
			int indiceDeAnalise = indiceAtual;
			Produto produtoAtual = produtos[indiceDeAnalise];
			while (indiceDeAnalise > 0 && produtoAtual.getValor() < produtos[indiceDeAnalise - 1].getValor()) {
				produtos[indiceDeAnalise] = produtos[indiceDeAnalise - 1];
				indiceDeAnalise--;
			}
			produtos[indiceDeAnalise] = produtoAtual;
		}
		return produtos;
	}
}
