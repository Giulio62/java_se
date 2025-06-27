package day04;

import java.util.Scanner;

public class NumeroParoleDiUnaStringa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("scrivi una frase: ");
		String frase = input.nextLine();
		int lunghezza = frase.length();
		int numSpazi =0;
		System.out.println("lunghezza: " + lunghezza);
		// Iterare su elementi di un array: for (int i = 0; i < array.length; i++)
		// { System.out.println(array[i]);
		for (int i = 1; i < lunghezza; i++)
		// char carattereEstratto = nomeStringa.charAt(indice);
		{
			char carattereEstratto = frase.charAt(i);		
			if (carattereEstratto == ' ') {
				System.out.println(carattereEstratto);
				numSpazi=numSpazi+1;
			}
			System.out.println("frase: " + frase);	
			System.out.println("lunghezza: " + lunghezza);	
			System.out.println("spazi: " + numSpazi);	
			System.out.println("parole: " + (numSpazi+1));	
		}
		input.close();
	}

}
