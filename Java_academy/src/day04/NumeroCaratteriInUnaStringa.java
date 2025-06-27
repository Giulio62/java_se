package day04;
// contare occorrenze di un carattere

import java.util.Scanner;

public class NumeroCaratteriInUnaStringa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.println("scrivi una frase: ");
		String frase = input.nextLine();
		System.out.println("scrivi un carattere: ");
		char carattere = input.next().charAt(0);
	//	System.out.println("Carattere: " + carattere);

		int lunghezza = frase.length();
		int numcarattere = 0;
	//	System.out.println("lunghezza: " + lunghezza);

		for (int i = 0; i < lunghezza; i++) {
			char carattereEstratto = frase.charAt(i);
			if (carattereEstratto == carattere) {
				System.out.println(carattereEstratto);
				numcarattere = numcarattere + 1;
			}
		//	System.out.println("frase: " + frase);
		//	System.out.println("carattere: " + carattere);

		}
		System.out.println("numcarattere: " + numcarattere);	
		
		input.close();
	}
}
