package day12;
import java.time.Localdate;
import java.util.Hashmap;

public class Libro {
	private String isbn;	
    private String titolo;
    private Hashmap <String,Boolean> autori;
    private String casaEditrice;
    private String utente;
    private Data data_scadenza_prestito;
    
    public String getISDN() { 
        return isbn;
    }
    
    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getCasaEditrice() {
        return casaEditrice;
    }

    public String getUtente() {
        return utente;
    }

    public Data getData_scadenza_prestito() {
        return data_scadenza_prestito;
    }

    public Libro(String isbn, String titolo, String utente, Data data_scadenza_prestito) {
    	super();
    	this.isbn = isbn;
        this.titolo = titolo;
        this.autore = autore;
        this.utente = utente;
        this.data_scadenza_prestito = data_scadenza_prestito;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public void setData_scadenza_prestito(Data data_scadenza_prestito) {
        this.data_scadenza_prestito = data_scadenza_prestito;
    }

	public static void main(String[] args) {


        // 1. Creiamo un oggetto Data per la scadenza
        Data scadenzaOggi = new Data(29, 5, 2025); // Oggi è il 29 maggio 2025

        // 2. Creiamo un oggetto Libro
        Libro libroPrestato = new Libro("IS101", "Java for Dummies", "Alice", scadenzaOggi);

        // 3. Stampiamo le informazioni del libro
        System.out.println("Titolo del libro: " + libroPrestato.getTitolo());
        System.out.println("Prestato a: " + libroPrestato.getUtente());

        // Per stampare la data, dobbiamo accedere ai singoli componenti dell'oggetto Data
        System.out.println("Scadenza prestito: " +
                           libroPrestato.getData_scadenza_prestito().getDay() + "/" +
                           libroPrestato.getData_scadenza_prestito().getMonth() + "/" +
                           libroPrestato.getData_scadenza_prestito().getYear());

        // Esempio di modifica: il libro viene ora prestato a Bob con una nuova scadenza
        libroPrestato.setUtente("Bob");
        libroPrestato.setData_scadenza_prestito(new Data(15, 6, 2025)); // Nuova scadenza

        System.out.println("\n--- Dopo la modifica ---");
        System.out.println("Prestato ora a: " + libroPrestato.getUtente());
        System.out.println("Nuova scadenza: " +
                           libroPrestato.getData_scadenza_prestito().getDay() + "/" +
                           libroPrestato.getData_scadenza_prestito().getMonth() + "/" +
                           libroPrestato.getData_scadenza_prestito().getYear());
		
		
	}

}
