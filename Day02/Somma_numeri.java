package Day02;

import java.util.Scanner;

/* Esercizio_01
 Somma di due numeri
 Traccia: Scrivi un programma Java che chieda all'utente di inserire due
 numeri interi e stampi la loro somma
*/


public class Somma_numeri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input =new Scanner (System.in);
		System.out.print("Inserisci primo numero ");
		int numero1= input.nextInt();
		System.out.print("Inserisci secondo numero ");
		int numero2= input.nextInt();
		int somma= numero1+numero2;
		System.out.println("la somma è "+somma);
		input.close();
	}

}
