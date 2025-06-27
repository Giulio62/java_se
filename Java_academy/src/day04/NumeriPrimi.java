package day04;

import java.util.Scanner;

public class NumeriPrimi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Digita il numero dei primi numeri primi che vuoi visualizzare");
		String numeroStringa = input.nextLine();
		int n = Integer.parseInt(numeroStringa);
		System.out.print("I primi " + n + " numeri primi sono:");
		int num = 1, nPrimi = 0;
		boolean isPrimo;
		while (nPrimi < n) {
			isPrimo = primo(num);
			if (isPrimo) {
				System.out.print(num + " ");
				nPrimi++;
			}
			num++;
		}
		input.close();
	}

	public static boolean primo(int num) {
		int lim = num / 2;
		boolean isPrimo = true;
		for (int div = 2; div <= lim && isPrimo; div++)
			if (num % div == 0)
				isPrimo = false;
		return isPrimo;
	}
}
