package day04;

import java.util.Scanner;

// palindromo

public class palindromo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("scrivi un testo: ");
		String frase = input.nextLine();
		String fraseInvertita = "";
		int lunghezza = frase.length();
		System.out.println("lunghezza: " + lunghezza);
		// Iterare su elementi di un array: for (int i = 0; i < array.length; i++)
		// { System.out.println(array[i]);
		System.out.println("lunghezza"+lunghezza);
		for (int i = lunghezza-1; i >=0; i--)
		// char carattereEstratto = nomeStringa.charAt(indice);
		{
			char carattereEstratto = frase.charAt(i);
			System.out.println("char "+carattereEstratto);	
			fraseInvertita = fraseInvertita + carattereEstratto;
		}
		
		
		if (frase.equals(fraseInvertita) ) {
			System.out.println("ok uguale, parola palindroma");
		}
		System.out.println("frase: " + frase);
		System.out.println("frase invertita: " + fraseInvertita);
		//System.out.println("lunghezza: " + lunghezza);


	}

}
