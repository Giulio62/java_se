package day03;

import java.util.Random;

/* Gioco del lancio del dado
 * Traccia: Scrivi un programma Java che simuli il lancio di un dado a sei facce.
 * Il programma dovrà generare casualmente un numero compreso tra 1 e 6 e
 * stamparlo a schermo.
 * si può fare sia scrivendo Math.random() * 7;
 * oppure Math.random() * 6 +1 ;
 */


public class LancioDado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

         double doubleRandomNumber = Math.random() * 7;
         System.out.println("doubleRandomNumber = " + doubleRandomNumber);
         // converti il double in numero intero
         int randomNumber = (int)doubleRandomNumber;
         System.out.println("randomNumber = " + randomNumber);
		
	}

}
