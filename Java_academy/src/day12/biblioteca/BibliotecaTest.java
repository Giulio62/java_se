package day12.biblioteca;



import java.util.HashMap;

public class BibbliotecaTest {

	public static void main(String[] args) {
		HashMap<String, Boolean> autori = new HashMap<>();
		// String partitaIva, String nome, String indirizzo
		Editore mondadori = new Editore("12345678900", "Arnoldo Mondadori Editore S.p.A.",
				"Via Arnoldo Mondadori, 1, 20054 Segrate (MI), Italia");
		// String isbn, String titolo, HashMap<String, Boolean> autori, Editore
		// casaeditrice
		Libro ilVecchioeIlMare = new Libro("andoghordfa", "Il vecchio e il mare",
				autori.put("Ernest Hemingway", true), mondadori);
		String risposta = ArchivioController.nuovoLibro(ilVecchioeIlMare);
		System.out.println(risposta);

	}

}