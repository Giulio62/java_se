package day04;
import java.util.Scanner;

public class Fattoriale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("scrivi numero per calcolare il fattoriale: ");
		String numeroStringa = input.nextLine();
		int numero = Integer.parseInt(numeroStringa);  
				
		int i, fact = 1;
		for (i = 1; i <= numero; i++) {
			fact = fact * i;
		}
		System.out.println("Fattoriale di " + numero + " è: " + fact);

	}

}
