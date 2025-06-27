
package day07;

import java.util.Random;

public class GiardinoAsilo {

	public static void main(String[] args) {
		// Nomi dei bambini in ordine alfabetico
		String[] bambini = { "Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph",
				"Kincaid", "Larry"

		};

		// Codici delle piante
		char[] piante = { 'G', 'C', 'R', 'E' };

		Random rand = new Random();

		// Genera le due righe di 24 caratteri casuali
		StringBuilder primaFila = new StringBuilder();
		StringBuilder secondaFila = new StringBuilder();

		for (int i = 0; i < 24; i++) {
			primaFila.append(piante[rand.nextInt(piante.length)]);
			secondaFila.append(piante[rand.nextInt(piante.length)]);

		}

		System.out.println("Prima fila: " + primaFila);
		System.out.println("Seconda fila: " + secondaFila);
		System.out.println();

		// Si assegnano 4 piante ad ogni bambino:
		// per ogni bambino prendiamo 2 lettere dalla prima fila e 2 dalla seconda

		for (int i = 0; i < bambini.length; i++) {
			int indice = i * 2; // ogni bambino ha 2 tazze per fila

			char pianta1 = primaFila.charAt(indice);
			char pianta2 = primaFila.charAt(indice + 1);
			char pianta3 = secondaFila.charAt(indice);
			char pianta4 = secondaFila.charAt(indice + 1);

			System.out.println(bambini[i] + ": " + piantaToNome(pianta1) + ", " + piantaToNome(pianta2) + ", "
					+ piantaToNome(pianta3) + ", " + piantaToNome(pianta4));

		}
	}

	// Mostro il codice generato automaticamente
	public static String piantaToNome(char c) {
		return switch (c) {
		case 'G' -> "Erba";
		case 'C' -> "Trifoglio";
		case 'R' -> "Ravanello";
		case 'E' -> "Violetta";
		default -> "Sconosciuta";
		};
	}
}
