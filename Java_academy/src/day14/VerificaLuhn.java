package day14;

import java.util.Scanner;

/*
 * Esempio 1: numero di carta di credito valido
 * 4539 3195 0343 6467
 * Il primo passo dell'algoritmo di Luhn è raddoppiare ogni seconda cifra, partendo da destra. Raddoppieremo
 * parte della sequenza :                   4_3_ 3_9_ 0_4_ 6_6_
 * posiziione nella sequenza:            14 13  11 9   7   5   3  1
 * Se raddoppiando il numero si ottiene un numero maggiore di 9, sottraiamo 9 dalla somma. I risultati del nostro raddoppio:
 *    8569 6195 0383 3437
 *Quindi somma tutte le cifre: 8+5+6+9+6+1+9+5+0+3+8+3+3+4+3+7 = 80
 * Se la somma è divisibile per 10, allora il numero è valido. Questo numero è valido
 */

public class VerificaLuhn {
    
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("inserisci una sequenza di 16 cifre");
		String numeri= input.nextLine();
		int somma=0;
		numeri=numeri.replace(" ", "");
		for (int i=numeri.length()-1; i>0; i--) { 
			int prodotto= (numeri.charAt(i)-'0')*2;
			if (i%2!=0) { // prendi gli indici dispari
				prodotto=prodotto*2;
				if (prodotto >9) {
					prodotto=-9;
					
				}
			}
			somma+=prodotto;
		}
		if (somma%10==0) {
			System.out.println("numero di luhn valido");
		}
		else {
			System.out.println("numero di luhn non valido");

		}
		
	}

}
