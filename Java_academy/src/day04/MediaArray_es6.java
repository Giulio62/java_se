package day04;
//media array
import java.util.Scanner;

public class MediaArray_es6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] tabella; // Array declaration
		tabella = new double[10];
		Scanner input = new Scanner(System.in);
		System.out.println("scrivi numero elementi della tabella: ");
		String numArray = input.nextLine();
		int numArrayn = Integer.parseInt(numArray);
		double totTabella =0;
		
		//for (int i = 1; i <= 5; i++) {
		//	Dichiarazione
		//	}
		
		// riempimento tabella
		for (int i=0;i<numArrayn;i++) {
			System.out.println("scrivi numero : "+i);
			String numero = input.nextLine();	
			tabella[i]=Double.parseDouble(numero);	
		}
		// calcolo num totali:
		for (int i=0;i<numArrayn;i++) {
			totTabella=totTabella+tabella[i];
		}
		
		System.out.println("scrivi tot Tabella : "+totTabella);  
		System.out.println("scrivi media : "+totTabella/numArrayn);  

		
	//	double basen = Double.parseDouble(base);
	//	double esponenten = Double.parseDouble(esponente);
	//	System.out.println(Math.pow(basen, esponenten));
		input.close();

	}

}
