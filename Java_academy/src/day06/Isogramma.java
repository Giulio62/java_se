package day06;
import java.util.Scanner;

/*
 * Esercizio 03
 * Isogramma
 * Determinare se una parola o una frase è un isogramma.
 */

public class Isogramma {

	public static boolean isIsogramma(String input) {
		input = input.toLowerCase();

		boolean[] lettereViste = new boolean[26];

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (c == ' ' || c == '-') {
				continue;
			}

			if (c >= 'a' && c <= 'z') {
				int indice = c - 'a';
				if (lettereViste[indice]) {
					return false;
				} else {
					lettereViste[indice] = true;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci una parola o frase per verificare se è un isogramma:");
		String frase = input.nextLine();

		if (isIsogramma(frase)) {
			System.out.println("La frase è un isogramma.");
		} else {
			System.out.println("La frase non è un isogramma.");
		}

		input.close();
	}
}

