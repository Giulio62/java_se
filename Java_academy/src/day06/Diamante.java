package day06;

// diamante... al momento faccio soltanto per minuscolo.

import java.util.Scanner;

public class Diamante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.println("inserisci carattere : ");
		String carattere = input.nextLine();

        char char1 = carattere.charAt(0);
        System.out.println("ASCII value of '" + char1 + "' is " + carattere.charAt(0));
		
        System.out.println(carattere.charAt(0));
		//System.out.println("scrivi num: " + numero);
		
        int delta=carattere.charAt(0)-97; // distanza da "a"
        
        int x = char1;

        System.out.println("ASCII value of '" + char1 + "' is " + x);
        System.out.println("delta '" + delta);
        
        
    	//		System.out.println(" 1scrivi num: " + numero);
		//		System.out.print(" 1passi: " + passi);
	
        for (int i = 0; i < delta; i++) {
        	  System.out.println(i);
        	}
        for (int i = delta; i >0; i--) {
      	  System.out.println(i);
      	}

        
        
        
		int finito = 0; // metto 1 quando è finito

		while (finito == 1) {

		//	if (carattere.charAt(0) == 0) {
		//		numero = numero / 2;
		//		passi = passi+1;
		//		System.out.println(" 1scrivi num: " + numero);
		//		System.out.print(" 1passi: " + passi);
		//	}

		//	if (numero % 2 == 1) {
		//		numero = numero * 3 + 1;
		//		passi = passi+1;
		//		//System.out.println("2scrivi num: " + numero);
		//		//System.out.print(" 2passi: " + passi);
			}
		//}
		//System.out.print(" 3scrivi num: " + numeroi);
		//System.out.print(" 2passi: " + passi);


		input.close();
		
		
		
		
		
	}

}
