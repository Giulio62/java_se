package day04;

	import java.util.Scanner;

    public class RicercaIntero {
		// ricerca numeri interi

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				// 	import java.util.Scanner;
				double[] tabella; // Array declaration
				tabella = new double[10];
				Scanner input = new Scanner(System.in);
				System.out.println("scrivi numero elementi della tabella: ");
				String numArray = input.nextLine();
				int numArrayn = Integer.parseInt(numArray);
				double totTabella =0;
				

		
				
				 
				for (int i = 0; i < numArrayn; i++) {
					System.out.print("scrivi numero da inserire in tabella: " + i);
					String numero = input.nextLine();
					tabella[i] = Integer.parseInt(numero);
				}
		        
				System.out.println("scrivi numero da cercare in tabella: ");
				String numero = input.nextLine();
				int numeroDaRicercare = Integer.parseInt(numero);   
				// calcolo num totali:
				for (int i = 0; i < numArrayn; i++) {
					if (numeroDaRicercare==tabella[i]) { 
						System.out.println("trovato in posizione: "+i);	  
			         }
	 
				}

				input.close();

			}

		}
