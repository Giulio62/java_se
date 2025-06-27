package day04;

import java.util.Scanner;

public class MaxMin {
	// massimo e minimo in tabella interi

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] tabella; // Array declaration
		tabella = new Integer[10];
		Scanner input = new Scanner(System.in);
		System.out.println("scrivi numero elementi della tabella: ");
		String numArray = input.nextLine();
		int numArrayn = Integer.parseInt(numArray);
		double totTabella = 0;
        int minNumero=Integer.MAX_VALUE;
        int maxNumero=Integer.MIN_VALUE;		
		
		// riempimento tabella
		for (int i = 0; i < numArrayn; i++) {
			System.out.println("scrivi numero : " + i);
			String numero = input.nextLine();
			tabella[i] = Integer.parseInt(numero);
		}
		// calcolo num totali:
		for (int i = 0; i < numArrayn; i++) {
	      if (tabella[i]<minNumero) {
	    	  minNumero=tabella[i];  	  
	      }
	      if (tabella[i]>maxNumero) {
	    	  maxNumero=tabella[i];  	  
	      }	
	    	  
		}

		System.out.println("minNumero : " + minNumero);
		System.out.println("maxNumero : " + maxNumero);

		// double basen = Double.parseDouble(base);
		// double esponenten = Double.parseDouble(esponente);
		// System.out.println(Math.pow(basen, esponenten));
		input.close();

	}

}
