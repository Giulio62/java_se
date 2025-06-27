package day04;

import java.util.Scanner;

public class VisualizzaElementiTabella {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] tabella; // Array declaration
		tabella = new double[10];
		Scanner input = new Scanner(System.in);
		System.out.println("inserisci numero elementi della tabella: ");
		String numArray = input.nextLine();
		int numArrayn = Integer.parseInt(numArray);
		double totTabella = 0;

		for (int i = 0; i < numArrayn; i++) {
			System.out.print("inserisci numero da inserire in tabella: " + i);
			String numero = input.nextLine();
			tabella[i] = Integer.parseInt(numero);
		}

		System.out.println("scrivi  tabella: ");
		for (int i = 0; i < numArrayn; i++) {
			System.out.println("posizione: " + i + " - " + tabella[i]);
		}
		input.close();

	}

}
