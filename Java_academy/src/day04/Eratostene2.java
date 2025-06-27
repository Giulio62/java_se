package day04;

import java.util.Scanner;
/*
public class Eratostene2 {
	public static void main(String[]args){
	Scanner scanner=new Scanner (System.in);
	System.out.println("Inserisci un numero e ti darò i numeri primi fino a quel numero");
	int numero=scanner.nextInt();
	boolean[] isPrimo=new boolean[numero+1]; //creazione array booleano default false
	for (int i=2; i=numero; i++){
	isPrimo[i]=true;
	}
	for (int j=i*i; j<=numero; j+=i);{
	isPrimo[j]=false;
	}
}
}
*/

public class Eratostene2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero e ti darò i numeri primi fino a quel numero:");
        int numero = scanner.nextInt();
        // Controlliamo che il numero sia almeno 2, dato che i primi partono da lì
        if (numero < 2) {
            System.out.println("Non ci sono numeri primi fino a " + numero + ".");
            scanner.close();
            return;
        }
        // Creazione array booleano:
        // isPrimo[i] sarà true se i è un numero primo, false altrimenti.
        // La dimensione è numero + 1 perché vogliamo includere 'numero' stesso.
        boolean[] isPrimo = new boolean[numero + 1];
        // Inizializza tutti gli elementi da 2 a 'numero' a true.
        // 0 e 1 non sono primi, quindi isPrimo[0] e isPrimo[1] rimarranno false (default).
        for (int i = 2; i <= numero; i++) { // Correzione: i <= numero
            isPrimo[i] = true;
        }
        // Implementazione del Crivello di Eratostene
        // Ciclo esterno: itera sui potenziali numeri primi (p)
        for (int p = 2; p * p <= numero; p++) { // Condizione ottimizzata: p*p anziché p <= sqrt(numero)
            // Se isPrimo[p] è true, allora p è un numero primo
            if (isPrimo[p]) {
                // Ciclo interno: contrassegna tutti i multipli di p come non primi
                // Inizia da p*p perché i multipli più piccoli (es. 2*p, 3*p)
                // sono già stati contrassegnati da numeri primi inferiori (2, 3, etc.)
                for (int i = p * p; i <= numero; i += p) { // Correzione: rimosso ';' e variabile 'i' qui
                    isPrimo[i] = false;
                }
            }
        }

        // Stampa i numeri primi
        System.out.println("Numeri primi fino a " + numero + ":");
        for (int i = 2; i <= numero; i++) {
            if (isPrimo[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // Per andare a capo alla fine

        scanner.close();
    }
}