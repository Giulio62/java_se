package day12;

import java.util.ArrayList; // Per usare ArrayList

// Assicurati che le classi Libro, Abbonato e Data siano definite correttamente nel package day12
// Ad esempio:
// public class Data { /* ... */ }
// public class Abbonato { /* ... */ }
// public class Libro { /* ... */ }

public class ArchivioBiblioteca {

    // Utilizziamo ArrayList per gestire le collezioni di libri e abbonati in modo dinamico
    private ArrayList<Libro> libri;       // Lista di oggetti Libro
    private ArrayList<Abbonato> abbonati; // Lista di oggetti Abbonato

    // Costruttore per inizializzare le liste quando viene creato un oggetto ArchivioBiblioteca
    public ArchivioBiblioteca() {
        this.libri = new ArrayList<>();       // Inizializza la lista dei libri vuota
        this.abbonati = new ArrayList<>();    // Inizializza la lista degli abbonati vuota
    }

    // Metodi per la gestione della biblioteca

    // Aggiunge un nuovo libro all'archivio
    public void nuovoLibro(String unTitolo) {
        // Per ora, creiamo un libro senza utente o data di scadenza (disponibile)
        // Potresti voler un costruttore Libro più semplice per questo scopo, o passare null
        // oppure, meglio, un costruttore che gestisce la disponibilità
        this.libri.add(new Libro(unTitolo, null, null)); // Assumiamo un costruttore Libro(titolo, utente, data)
        System.out.println("Libro '" + unTitolo + "' aggiunto.");
    }

    // Aggiunge un nuovo utente all'archivio
    public void nuovoUtente(String unNome, String unCognome) {
        this.abbonati.add(new Abbonato(unCognome, unNome)); // Assumiamo un costruttore Abbonato(cognome, nome)
        System.out.println("Utente " + unNome + " " + unCognome + " aggiunto.");
    }

    // Trova un utente e ritorna il suo indice nella lista, o -1 se non trovato
    public int trovaUtente(String unNome, String unCognome) {
        for (int i = 0; i < abbonati.size(); i++) {
            Abbonato abbonatoCorrente = abbonati.get(i);
            // Confrontiamo ignorando la case per maggiore robustezza
            if (abbonatoCorrente.getNome().equalsIgnoreCase(unNome) &&
                abbonatoCorrente.getCognome().equalsIgnoreCase(unCognome)) {
                return i; // Utente trovato all'indice i
            }
        }
        return -1; // Utente non trovato
    }

    // Calcola la data di scadenza (ad esempio, 30 giorni da 'date')
    public Data scadenza(Data dataInizioPrestito) {
        // Questa implementazione è semplificata e non tiene conto dei mesi/anni
        // In una vera applicazione, useresti la classe LocalDate di Java 8+
        // o una libreria di date più robusta.
        // Per ora, assumiamo un semplice incremento dei giorni.
        int giorno = dataInizioPrestito.getDay() + 30; // Aggiungi 30 giorni
        int mese = dataInizioPrestito.getMonth();
        int anno = dataInizioPrestito.getYear();

        // Implementazione molto rudimentale per gestire il passaggio di mese
        // NON accurata per tutti i casi (es. febbraio, anni bisestili)
        if (giorno > 31) { // Esempio semplificato
            giorno -= 31;
            mese += 1;
            if (mese > 12) {
                mese = 1;
                anno += 1;
            }
        }
        return new Data(giorno, mese, anno);
    }

    // Presta un libro a un utente
    // Ritorna 0 se successo, -1 se libro non trovato, -2 se utente non trovato, -3 se libro già prestato
    public int presta(Libro unLibro, Abbonato unUtente) {
        if (!libri.contains(unLibro)) { // Verifica se il libro esiste nell'archivio
            System.out.println("Errore: Libro non presente in archivio.");
            return -1;
        }
        if (!abbonati.contains(unUtente)) { // Verifica se l'utente esiste nell'archivio
            System.out.println("Errore: Utente non registrato.");
            return -2;
        }

        // Verifica se il libro è già prestato (assumendo che utente null significhi disponibile)
        if (unLibro.getUtente() != null) {
            System.out.println("Errore: Il libro è già prestato a " + unLibro.getUtente());
            return -3;
        }

        // Ottieni la data corrente (assumiamo un modo per farlo, altrimenti la si passa come parametro)
        // Per semplicità, usiamo una data fissa o ne creiamo una per l'esempio
        Data dataCorrente = new Data(29, 5, 2025); // Data di oggi (simulata)

        // Calcola la data di scadenza
        Data dataScadenza = scadenza(dataCorrente);

        // Aggiorna lo stato del libro
        unLibro.setUtente(unUtente.getNome() + " " + unUtente.getCognome()); // Assumendo setUtente accetti una stringa
        unLibro.setData_scadenza_prestito(dataScadenza);

        System.out.println("Libro '" + unLibro.getTitolo() + "' prestato a " + unUtente.getNome() + " " + unUtente.getCognome() +
                           " fino al " + dataScadenza.getDay() + "/" + dataScadenza.getMonth() + "/" + dataScadenza.getYear());
        return 0; // Successo
    }

    // Aggiorna lo stato dei prestiti (es. verifica scadenze)
    public void aggiorna() {
        System.out.println("Aggiornamento stato prestiti...");
        Data dataCorrente = new Data(29, 5, 2025); // Data di oggi (simulata)

        for (Libro libro : libri) {
            if (libro.getUtente() != null && libro.getData_scadenza_prestito() != null) {
                // Una vera comparazione di date sarebbe più complessa.
                // Qui, per semplicità, un controllo rudimentale.
                // Dovresti implementare un metodo isEqual o isAfter nella classe Data
                // oppure usare l'API java.time (LocalDate)
                // if (libro.getData_scadenza_prestito().isBefore(dataCorrente)) { ... }
                // Per ora, solo un messaggio generico.
                System.out.println("Libro '" + libro.getTitolo() + "' è prestato a " + libro.getUtente() +
                                   " con scadenza il " + libro.getData_scadenza_prestito().getDay() + "/" +
                                   libro.getData_scadenza_prestito().getMonth() + "/" +
                                   libro.getData_scadenza_prestito().getYear());
            }
        }
        System.out.println("Aggiornamento completato.");
    }

    // Conta i libri prestati a un abbonato
    public int numLibri(Abbonato unAbb) {
        int contatore = 0;
        for (Libro libro : libri) {
            // Assumiamo che getUtente() ritorni il nome completo come stringa
            // Dovresti avere un modo più robusto per collegare Libro ad Abbonato,
            // ad esempio, il campo 'utente' di Libro potrebbe essere di tipo Abbonato
            // e quindi potresti confrontare 'libro.getUtente().equals(unAbb)'
            if (libro.getUtente() != null &&
                (unAbb.getNome() + " " + unAbb.getCognome()).equalsIgnoreCase(libro.getUtente())) {
                contatore++;
            }
        }
        return contatore;
    }


    public static void main(String[] args) {
        // Creazione di un'istanza dell'archivio
        ArchivioBiblioteca miaBiblioteca = new ArchivioBiblioteca();

        // Aggiungiamo alcuni libri
        miaBiblioteca.nuovoLibro("Il Signore degli Anelli");
        miaBiblioteca.nuovoLibro("Cent'anni di solitudine");
        miaBiblioteca.nuovoLibro("1984");

        // Aggiungiamo alcuni abbonati
        miaBiblioteca.nuovoUtente("Mario", "Rossi");
        miaBiblioteca.nuovoUtente("Giulia", "Bianchi");

        // Troviamo un utente
        int indiceMario = miaBiblioteca.trovaUtente("Mario", "Rossi");
        if (indiceMario != -1) {
            System.out.println("Mario Rossi trovato all'indice: " + indiceMario);
        } else {
            System.out.println("Mario Rossi non trovato.");
        }

        // Otteniamo gli oggetti specifici per il prestito (qui è un po' più complesso)
        // In un sistema reale, cercheresti il libro e l'utente per nome/ID
        Libro libro1 = miaBiblioteca.libri.get(0); // Il Signore degli Anelli
        Abbonato abbonato1 = miaBiblioteca.abbonati.get(0); // Mario Rossi

        // Eseguiamo un prestito
        System.out.println("\n--- Effettuo prestito ---");
        miaBiblioteca.presta(libro1, abbonato1);

        // Tentiamo di prestare lo stesso libro (dovrebbe dare errore)
        System.out.println("\n--- Riprovo lo stesso prestito ---");
        miaBiblioteca.presta(libro1, abbonato1);

        // Aggiorniamo lo stato
        System.out.println("\n--- Aggiornamento ---");
        miaBiblioteca.aggiorna();

        // Contiamo i libri prestati a Mario Rossi
        System.out.println("\nLibri prestati a Mario Rossi: " + miaBiblioteca.numLibri(abbonato1));


        // **Nota importante per la data:**
        // Le operazioni con le date (come scadenza) sono implementate in modo molto basilare qui.
        // Per una gestione robusta delle date in Java, è fortemente consigliato usare
        // l'API `java.time` introdotta in Java 8 (es. `LocalDate`, `LocalDateTime`, `Period`).
        // Ad esempio:
        // import java.time.LocalDate;
        // import java.time.Period;
        // ...
        // public Data scadenza(Data dataInizioPrestito) {
        //     LocalDate inizio = LocalDate.of(dataInizioPrestito.getYear(), dataInizioPrestito.getMonth(), dataInizioPrestito.getDay());
        //     LocalDate fine = inizio.plus(Period.ofDays(30));
        //     return new Data(fine.getDayOfMonth(), fine.getMonthValue(), fine.getYear());
        // }
    }
}