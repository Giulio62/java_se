package day17;

public class Veicolo {

	// 1. Attributi (variabili di istanza) dichiarati come privati
	// Questo nasconde i dettagli interni e previene l'accesso diretto dall'esterno.
	private String targa;
	private String modello;
	private String marca;
	private int numeroPosti;

	// 2. Costruttore
	// Usato per creare nuove istanze di Veicolo e inizializzare i loro attributi.
	// Spesso si usano i setter all'interno del costruttore per sfruttare la loro
	// logica di validazione.

	public Veicolo(String targa, String modello, String marca, int numeroPosti) {
		this.setTarga(targa); // Usa il setter per validare la targa
		this.setModello(modello);
		this.setMarca(marca);
		this.setNumeroPosti(numeroPosti); // Usa il setter per validare il numero di posti
	}

	// 3. Metodi Getter pubblici
	// Permettono di leggere il valore degli attributi privati.
	public String getTarga() {
		return targa;
	}

	public String getModello() {
		return modello;
	}

	public String getMarca() {
		return marca;
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}

	// 4. Metodi Setter pubblici
	// Permettono di modificare il valore degli attributi privati.
	// Qui possiamo aggiungere logica di validazione o di business.

	public void setTarga(String targa) {
		// Esempio di validazione: la targa non può essere nulla o vuota
		// E potrebbe avere una lunghezza specifica o un formato regex
		if (targa != null && !targa.trim().isEmpty()) {
			this.targa = targa.trim().toUpperCase(); // Targa in maiuscolo e senza spazi iniziali/finali
		} else {
			System.err.println("Errore: La targa non può essere vuota.");
			// In un'applicazione reale, potresti lanciare un'eccezione
			// IllegalArgumentException
		}
	}

	public void setModello(String modello) {
		if (modello != null && !modello.trim().isEmpty()) {
			this.modello = modello.trim();
		} else {
			System.err.println("Errore: Il modello non può essere vuoto.");
		}
	}

	public void setMarca(String marca) {
		if (marca != null && !marca.trim().isEmpty()) {
			this.marca = marca.trim();
		} else {
			System.err.println("Errore: La marca non può essere vuota.");
		}
	}

	public void setNumeroPosti(int numeroPosti) {
		// Esempio di validazione: il numero di posti deve essere positivo
		if (numeroPosti > 0) {
			this.numeroPosti = numeroPosti;
		} else {
			System.err.println("Errore: Il numero di posti deve essere un valore positivo.");
			// Potresti impostare un valore di default o lanciare un'eccezione
		}
	}

	// Un metodo di utilità per visualizzare le informazioni del veicolo
	@Override // Sovrascrive il metodo toString() della classe Object
	public String toString() {
		return "Veicolo [Targa: " + targa + ", Modello: " + modello + ", Marca: " + marca + ", Posti: " + numeroPosti
				+ "]";
	}

	public static void main(String[] args) {
		// Creiamo un'istanza di Veicolo utilizzando il costruttore
		Veicolo auto1 = new Veicolo("AB123CD", "Panda", "Fiat", 4);
		System.out.println("Veicolo 1: " + auto1.toString());

		// Accesso agli attributi tramite i getter
		System.out.println("Targa di auto1: " + auto1.getTarga());
		System.out.println("Modello di auto1: " + auto1.getModello());

		// Modifichiamo gli attributi tramite i setter
		auto1.setTarga("ZZ999YY"); // Modifica valida
		auto1.setNumeroPosti(5); // Modifica valida
		System.out.println("Veicolo 1 aggiornato: " + auto1.toString());

		// Tentiamo di impostare valori non validi usando i setter,
		// e vediamo i messaggi di errore dalla logica di validazione.
		System.out.println("\n--- Tentativi di impostare valori non validi ---");
		auto1.setTarga(""); // Errore: Targa vuota
		auto1.setNumeroPosti(-2); // Errore: Numero posti negativo

		// Creiamo un veicolo con un costruttore che passa dati problematici
		System.out.println("\n--- Creazione veicolo con dati iniziali problematici ---");
		Veicolo auto2 = new Veicolo("XY123WZ", " ", "Ford", 0);
		System.out.println("Veicolo 2: " + auto2.toString());
		// Nota che il modello sarà comunque una stringa vuota o null a seconda
		// dell'implementazione
		// e il numero di posti rimarrà 0 (o il default iniziale) a causa della
		// validazione.
	}
}
