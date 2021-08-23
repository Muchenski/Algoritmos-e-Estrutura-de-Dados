package Algoritmos.Algoritmos_I;

public class Recursao {

	private static final int n = 10;

	private static boolean[] jaCalculado = new boolean[n + 1];

	private static long[] vezesCalculado = new long[n + 1];

	private static long[] F = new long[n + 1];

	public static void main(String[] args) {

		System.out.println("Testando fibonnaci recursivo com implementação ruim:");

		// Ocorrem muitos cálculos repetidos na árvore de recursão.
		// [OUT]:
		// 55
		// 0 foi calculado 34 vezes
		// 1 foi calculado 55 vezes
		// 2 foi calculado 34 vezes
		// 3 foi calculado 21 vezes
		// 4 foi calculado 13 vezes
		// 5 foi calculado 8 vezes
		// 6 foi calculado 5 vezes
		// 7 foi calculado 3 vezes
		// 8 foi calculado 2 vezes
		// 9 foi calculado 1 vezes

		System.out.println(fibonacciRuim(n));
		for (int i = 0; i < n; i++) {
			System.out.println(String.format("%d foi calculado %d vezes", i, vezesCalculado[i]));
		}

		limparVariaveisStaticas();
		System.out.println();

		System.out.println("Testando fibonnaci recursivo com implementação boa:");

		// Não ocorrem os cálculos repetidos para cada sequência da árvore de recursão.
		// [OUT]:
		// 55
		// 0 foi calculado 1 vezes
		// 1 foi calculado 1 vezes
		// 2 foi calculado 1 vezes
		// 3 foi calculado 1 vezes
		// 4 foi calculado 1 vezes
		// 5 foi calculado 1 vezes
		// 6 foi calculado 1 vezes
		// 7 foi calculado 1 vezes
		// 8 foi calculado 1 vezes
		// 9 foi calculado 1 vezes

		System.out.println(fibonacciBom(n));
		for (int i = 0; i < n; i++) {
			System.out.println(String.format("%d foi calculado %d vezes", i, vezesCalculado[i]));
		}

	}

	public static long fibonacciBom(int n) {
		if (jaCalculado[n]) {
			return F[n];
		}
		jaCalculado[n] = true;
		vezesCalculado[n]++;
		if (n == 0) {
			F[n] = 0;
		} else if (n == 1) {
			F[n] = 1;
		} else {
			F[n] = fibonacciBom(n - 1) + fibonacciBom(n - 2);
		}
		return F[n];
	}

	public static int fibonacciRuim(int n) {
		vezesCalculado[n]++;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return fibonacciRuim(n - 1) + fibonacciRuim(n - 2);
	}

	public static int fatorial(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * fatorial(n - 1);
	}

	private static void limparVariaveisStaticas() {
		jaCalculado = new boolean[n + 1];
		vezesCalculado = new long[n + 1];
		F = new long[n + 1];
	}
}
