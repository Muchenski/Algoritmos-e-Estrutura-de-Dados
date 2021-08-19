package Algoritmos.Algoritmos_II;

import Algoritmos.entidades.DadosBusca;
import Algoritmos.entidades.Nota;

public class BuscaBinaria {

	public static void main(String[] args) {

		Nota nota1 = new Nota("Jonas", 3.0);
		Nota nota2 = new Nota("André", 4.0);
		Nota nota3 = new Nota("Mariana", 5.0);
		Nota nota4 = new Nota("Juliana", 6.7);
		Nota nota5 = new Nota("Guilherme", 7.0);
		Nota nota6 = new Nota("Carlos", 8.5);
		Nota nota7 = new Nota("Paulo", 9.0);
		Nota nota8 = new Nota("Lúcia", 9.3);
		Nota nota9 = new Nota("Ana", 10.0);

		Nota[] notasOrdenadas = { nota1, nota2, nota3, nota4, nota5, nota6, nota7, nota8, nota9 };
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// Testando busca com valores existentes:

		System.out.println(buscaBinaria(notasOrdenadas, 0, notasOrdenadas.length, nota1.getValor()));

		System.out.println();

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// Testando busca com valores inexistentes:
		
		System.out.println(buscaBinaria(notasOrdenadas, 0, notasOrdenadas.length, 3.1));
	}

	public static DadosBusca buscaBinaria(Nota[] notas, int indiceInicial, int quantidadeDeElementos, double notaBuscada) {
		return buscaBinaria(notas, indiceInicial, quantidadeDeElementos, notaBuscada, 0);
	}
	
	private static DadosBusca buscaBinaria(Nota[] notas, int indiceInicial, int quantidadeDeElementos, double notaBuscada, int passos) {

		passos++;

		int indiceDoMeio = (indiceInicial + quantidadeDeElementos) / 2;

		if (notaBuscada > notas[quantidadeDeElementos - 1].getValor().doubleValue() || indiceDoMeio > notas.length - 1) {
			return new DadosBusca(-1, passos);
		}

		Nota notaDoMeio = notas[indiceDoMeio];

		if (notaBuscada == notaDoMeio.getValor().doubleValue()) {
			return new DadosBusca(indiceDoMeio, passos);
		}

		// Nota buscada está na esquerda
		if (notaBuscada < notaDoMeio.getValor().doubleValue()) {
			return buscaBinaria(notas, indiceInicial, indiceDoMeio, notaBuscada, passos);
		}
		// Nota buscada está na direita
		return buscaBinaria(notas, indiceDoMeio + 1, quantidadeDeElementos, notaBuscada, passos);

	}

}
