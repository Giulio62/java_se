package day04;

import java.util.Scanner;

public class Potenza {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.println("scrivi base: ");
		String base = input.nextLine();
		System.out.println("scrivi esponente: ");
		String esponente = input.nextLine();
		double basen = Double.parseDouble(base);
		double esponenten = Double.parseDouble(esponente);
		
		System.out.println(Math.pow(basen, esponenten));
		input.close();
	}

}
