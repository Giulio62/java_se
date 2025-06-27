package day04;

import java.util.*;

public class Erastotene {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Inserire il numero di interi desiderato: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		List<Integer> listNumbers = new ArrayList<Integer>();
		List<Integer> numbersToExclude = new ArrayList<Integer>();
		for (int i = 2; i < num; i++) {
			int mul = i;
			if (numbersToExclude.contains(i))
				break;
			if (i == 2 || !isPrime(i)) {
				for (int j = i; j < num;) {
					numbersToExclude.add(j);
					j = j + mul;
				}
			}
			
	
		}

		
		for (int i = 2; i < num; i++) {
			if (!numbersToExclude.contains(i)) {
				listNumbers.add(i);
			}
	
		}
		System.out.println(String.format("Lista numeri primi fino ad %d  : %s", num, listNumbers));
	
		scan.close();
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
