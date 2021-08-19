package Algoritmos.Algoritmos_II;

import java.util.List;

import Algoritmos.entidades.Nota;

public class QuickSort {

	public static void main(String[] args) {

		Nota nota1 = new Nota("André", 4.0);
		Nota nota2 = new Nota("Mariana", 5.0);
		Nota nota3 = new Nota("Carlos", 8.5);
		Nota nota4 = new Nota("Paulo", 9.0);
		Nota nota5 = new Nota("Jonas", 3.0);
		Nota nota6 = new Nota("Juliana", 6.7);
		Nota nota7 = new Nota("Guilherme", 7.0);
		Nota nota8 = new Nota("Lúcia", 9.3);
		Nota nota9 = new Nota("Ana", 10.0);

		Nota[] notasDesordenadas = { nota1, nota3, nota9, nota5, nota6, nota8, nota4, nota2, nota7 };

		List.of(ordenar(notasDesordenadas, 3, notasDesordenadas.length - 3)).forEach(System.out::println);
		System.out.println();
		List.of(ordenar(notasDesordenadas, 0, notasDesordenadas.length)).forEach(System.out::println);
	}

	public static Nota[] ordenar(Nota[] notas, int indiceInicial, int quantidadeDeElementos) {
		int quantidadeDeElementosRestantes = quantidadeDeElementos - indiceInicial;
		int indiceAtual = indiceInicial;
		if (quantidadeDeElementosRestantes > 1) {
			int indiceDoPivo = quickSort(notas, indiceAtual, quantidadeDeElementos);
			notas = ordenar(notas, indiceAtual, indiceDoPivo); // Ordena itens a esquerda do pivo.
			notas = ordenar(notas, indiceDoPivo + 1, quantidadeDeElementos); // Ordena itens a direita do pivo.
		}
		return notas;
	}

	public static int quickSort(Nota[] notas, int indiceInicial, int quantidadeDeElementos) {
		int indiceDoPivo = quantidadeDeElementos - 1;
		Nota pivo = notas[indiceDoPivo];
		int quantidadeDeNotasMenores = indiceInicial;
		for (int indiceAtual = indiceInicial; indiceAtual < quantidadeDeElementos - 1; indiceAtual++) {
			if (pivo.getValor() >= notas[indiceAtual].getValor()) {
				notas = trocarNotas(notas, indiceAtual, quantidadeDeNotasMenores);
				quantidadeDeNotasMenores++;
			}
		}
		notas = trocarNotas(notas, indiceDoPivo, quantidadeDeNotasMenores);
		return indiceDoPivo;
	}

	public static Nota[] trocarNotas(Nota[] notas, int indiceOriginal, int indiceDestino) {
		Nota notaIndiceOriginal = notas[indiceOriginal];
		Nota notaIndiceDestino = notas[indiceDestino];
		notas[indiceOriginal] = notaIndiceDestino;
		notas[indiceDestino] = notaIndiceOriginal;
		return notas;
	}

}
