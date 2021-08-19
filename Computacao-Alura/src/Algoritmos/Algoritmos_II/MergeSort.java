package Algoritmos.Algoritmos_II;

import java.util.List;

import Algoritmos.entidades.Nota;

public class MergeSort {

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
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Teste: intercalando 2 arrays ordenados:

		Nota[] notasProfMauricio = { nota1, nota2, nota3, nota4 };
		Nota[] notasProfAlberto = { nota5, nota6, nota7, nota8, nota9 };

		List.of(merge2Arrays(notasProfMauricio, notasProfAlberto)).forEach(System.out::println);
		System.out.println();
		List.of(merge2Arrays(notasProfAlberto, notasProfMauricio)).forEach(System.out::println);

		System.out.println();

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// Teste: intercalando 1 array formado a partir de 2 arrays ordenados:

		Nota[] notasOrdenadasEmDuasPartes = { nota1, nota2, nota3, nota4, nota5, nota6, nota7, nota8, nota9 };

		List.of(merge1Array(notasOrdenadasEmDuasPartes, 0, 4, notasOrdenadasEmDuasPartes.length)).forEach(System.out::println);
		System.out.println();
		List.of(merge1Array(notasOrdenadasEmDuasPartes, 0, 4, notasOrdenadasEmDuasPartes.length - 3)).forEach(System.out::println);
		System.out.println();
		List.of(merge1Array(notasOrdenadasEmDuasPartes, 0, 0, 1)).forEach(System.out::println);
		System.out.println();
		List.of(merge1Array(notasOrdenadasEmDuasPartes, 3, 4, 5)).forEach(System.out::println);
		System.out.println();
		List.of(merge1Array(notasOrdenadasEmDuasPartes, 0, 1, 2)).forEach(System.out::println);

		System.out.println();

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// Teste: Ordenando e intercalando 1 array a partir de dados desordenados:

		Nota[] notasDesordenadas = { nota1, nota3, nota9, nota5, nota6, nota7, nota4, nota2, nota8 };

		List.of(ordenar(notasDesordenadas, 0, notasDesordenadas.length)).forEach(System.out::println);
		System.out.println();
		List.of(ordenar(notasDesordenadas, 0, notasDesordenadas.length - 3)).forEach(System.out::println);
	}

	public static Nota[] ordenar(Nota[] notasDesordenadas, int indiceInicioPrimeiraParte, int quantidadeDeElementos) {
		Nota[] notasOrdenadas = notasDesordenadas;
		int quantidadeDeElementosRestantes = quantidadeDeElementos - indiceInicioPrimeiraParte;
		if (quantidadeDeElementosRestantes > 1) {
			int indiceInicioSegundaParte = (indiceInicioPrimeiraParte + quantidadeDeElementos) / 2;
			notasOrdenadas = ordenar(notasOrdenadas, indiceInicioPrimeiraParte, indiceInicioSegundaParte);
			notasOrdenadas = ordenar(notasOrdenadas, indiceInicioSegundaParte, quantidadeDeElementos);
			notasOrdenadas = merge1Array(notasOrdenadas, indiceInicioPrimeiraParte, indiceInicioSegundaParte, quantidadeDeElementos);
		}
		return notasOrdenadas;
	}

	public static Nota[] merge1Array(Nota[] notas, int indiceInicioPrimeiraParte, int indiceInicioSegundaParte,
			int quantidadeDeElementos) {

		Nota[] ranking = new Nota[quantidadeDeElementos - indiceInicioPrimeiraParte];

		int indiceAtualRanking = 0;
		int indiceAtualPrimeiraParte = indiceInicioPrimeiraParte;
		int indiceAtualSegundaParte = indiceInicioSegundaParte;

		while (indiceAtualPrimeiraParte < indiceInicioSegundaParte && indiceAtualSegundaParte < quantidadeDeElementos) {
			Nota notaComparacao01 = notas[indiceAtualPrimeiraParte];
			Nota notaComparacao02 = notas[indiceAtualSegundaParte];

			if (notaComparacao01.getValor() < notaComparacao02.getValor()) {
				ranking[indiceAtualRanking] = notas[indiceAtualPrimeiraParte];
				indiceAtualPrimeiraParte++;
			} else {
				ranking[indiceAtualRanking] = notas[indiceAtualSegundaParte];
				indiceAtualSegundaParte++;
			}

			indiceAtualRanking++;
		}

		if (indiceAtualPrimeiraParte < indiceInicioSegundaParte) {
			ranking = inserirRestante(indiceAtualPrimeiraParte, indiceAtualRanking, ranking.length, notas, ranking);
		}
		if (indiceAtualSegundaParte < quantidadeDeElementos) {
			ranking = inserirRestante(indiceAtualSegundaParte, indiceAtualRanking, ranking.length, notas, ranking);
		}

		for (int indiceAtual = 0; indiceAtual < ranking.length; indiceAtual++) {
			notas[indiceAtual + indiceInicioPrimeiraParte] = ranking[indiceAtual];
		}

		return notas;
	}

	public static Nota[] merge2Arrays(Nota[] notasProf01, Nota[] notasProf02) {

		Nota[] maiorArray = null;
		Nota[] menorArray = null;

		if (notasProf01.length > notasProf02.length) {
			maiorArray = notasProf01;
			menorArray = notasProf02;
		} else {
			maiorArray = notasProf02;
			menorArray = notasProf01;
		}

		int quantidadeTotalDeElementos = menorArray.length + maiorArray.length;

		Nota[] ranking = new Nota[quantidadeTotalDeElementos];

		int indiceAtualRanking = 0;
		int indiceAtualMaiorArray = 0;
		int indiceAtualMenorArray = 0;

		while (indiceAtualMaiorArray < maiorArray.length && indiceAtualMenorArray < menorArray.length) {
			Nota notaAtualMaiorArray = maiorArray[indiceAtualMaiorArray];
			Nota notaAtualMenorArray = menorArray[indiceAtualMenorArray];

			if (notaAtualMaiorArray.getValor() < notaAtualMenorArray.getValor()) {
				ranking[indiceAtualRanking] = notaAtualMaiorArray;
				indiceAtualMaiorArray++;
			} else {
				ranking[indiceAtualRanking] = notaAtualMenorArray;
				indiceAtualMenorArray++;
			}

			indiceAtualRanking++;
		}

		if (indiceAtualMaiorArray < maiorArray.length) {
			ranking = inserirRestante(indiceAtualMaiorArray, indiceAtualRanking, quantidadeTotalDeElementos, maiorArray, ranking);
		}
		if (indiceAtualMenorArray < menorArray.length) {
			ranking = inserirRestante(indiceAtualMenorArray, indiceAtualRanking, quantidadeTotalDeElementos, menorArray, ranking);
		}

		return ranking;
	}

	public static Nota[] inserirRestante(int indiceAtualArray, int indiceAtualRanking, int quantidadeDeElementos,
			Nota[] array, Nota[] ranking) {
		while (indiceAtualRanking < quantidadeDeElementos) {
			ranking[indiceAtualRanking] = array[indiceAtualArray];
			indiceAtualArray++;
			indiceAtualRanking++;
		}
		return ranking;
	}
}
