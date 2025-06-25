package it.java.app.controllo;

import it.java.app.modello.Data;
import it.java.app.servizio.ServizioUtente;
import it.java.app.modello.impl.ServizioUtenteImpl;

public class Main {
private static ServizioUtente servizioUtente = new ServizioUtenteImpl();

public static void main(String[] args) {
	try {
		Data user = servizioUtente.getUser(2);
		System.out.println(user);
	} catch (Exception e) {
		System.out.println("Ops...si è verificato un errore");
	}
}

}