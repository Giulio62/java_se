package day17;


import java.util.Scanner;
import java.util.concurrent.TimeUnit; // Per la pausa di un secondo

public class Navigatore_mappa {

    // --- Costanti del Campo ---
    private static final int LARGHEZZA_CAMPO = 70; // Colonne
    private static final int ALTEZZA_CAMPO = 20;   // Righe
    private static final char PUNTO_VUOTO = '.';

    // --- Stati dell'Oggetto ---
    private static char orientamentoCorrenteChar; // Carattere che rappresenta l'orientamento sulla mappa
    private static int orientamentoCorrenteIndex; // Indice per ciclare tra N, E, S, O
    private static int coordX; // Colonna attuale dell'oggetto
    private static int coordY; // Riga attuale dell'oggetto

    // Array per gestire il ciclo degli orientamenti (N -> E -> S -> O -> N)
    // N=0, E=1, S=2, O=3
    private static final char[] ORIENTAMENTI_CHARS = {'^', '>', 'v', '<'}; // N, E, S, O
    private static final String[] ORIENTAMENTI_LOGICI = {"N", "E", "S", "O"};


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // --- 1. Inizializzazione della Mappa ---
        char[][] campo = new char[ALTEZZA_CAMPO][LARGHEZZA_CAMPO];
        inizializzaCampo(campo);

        // --- 2. Input del Punto di Inizio e Orientamento ---
        System.out.println("--- Configurazione Iniziale Oggetto ---");

        // Input Orientamento
        orientamentoCorrenteIndex = -1; // Inizializza a un valore non valido
        while (orientamentoCorrenteIndex == -1) {
            System.out.print("Inserisci l'orientamento iniziale (N, S, E, O): ");
            String orientamentoInput = input.nextLine().trim().toUpperCase();
            switch (orientamentoInput) {
                case "N": orientamentoCorrenteIndex = 0; break;
                case "E": orientamentoCorrenteIndex = 1; break;
                case "S": orientamentoCorrenteIndex = 2; break;
                case "O": orientamentoCorrenteIndex = 3; break;
                default:
                    System.out.println("Orientamento non valido. Usa N, S, E, O.");
            }
        }
        orientamentoCorrenteChar = ORIENTAMENTI_CHARS[orientamentoCorrenteIndex];


        // Input e validazione della coordinata Y (riga)
        coordY = -1;
        while (coordY < 0 || coordY >= ALTEZZA_CAMPO) {
            System.out.print("Inserisci la coordinata Y iniziale (riga, da 0 a " + (ALTEZZA_CAMPO - 1) + "): ");
            if (input.hasNextInt()) {
                coordY = input.nextInt();
                if (coordY < 0 || coordY >= ALTEZZA_CAMPO) {
                    System.out.println("Errore: la coordinata Y deve essere tra 0 e " + (ALTEZZA_CAMPO - 1) + ".");
                }
            } else {
                System.out.println("Input non valido. Inserisci un numero intero.");
                input.next(); // Consuma l'input non valido
            }
        }
        input.nextLine(); // Consuma il resto della riga dopo nextInt()

        // Input e validazione della coordinata X (colonna)
        coordX = -1;
        while (coordX < 0 || coordX >= LARGHEZZA_CAMPO) {
            System.out.print("Inserisci la coordinata X iniziale (colonna, da 0 a " + (LARGHEZZA_CAMPO - 1) + "): ");
            if (input.hasNextInt()) {
                coordX = input.nextInt();
                if (coordX < 0 || coordX >= LARGHEZZA_CAMPO) {
                    System.out.println("Errore: la coordinata X deve essere tra 0 e " + (LARGHEZZA_CAMPO - 1) + ".");
                }
            } else {
                System.out.println("Input non valido. Inserisci un numero intero.");
                input.next(); // Consuma l'input non valido
            }
        }
        input.nextLine(); // Consuma il resto della riga dopo nextInt()

        // Posiziona l'oggetto iniziale sul campo
        if (posizionaOggetto(campo, coordY, coordX, orientamentoCorrenteChar)) {
            System.out.println("\n--- Mappa Iniziale ---");
            stampaCampo(campo);
        } else {
            System.out.println("Impossibile posizionare l'oggetto. Coordinate iniziali fuori dai limiti.");
            input.close();
            return;
        }

        // --- 3. Input della Stringa di Comandi ---
        System.out.print("Inserisci la sequenza di comandi (L=Sinistra, R=Destra, A=Avanti): ");
        String comandi = input.nextLine().trim().toUpperCase();

        // --- 4. Esecuzione dei Comandi con Animazione ---
        System.out.println("\n--- Avvio Sequenza Comandi ---");
        for (char comando : comandi.toCharArray()) {
            // Pulisci la posizione precedente sulla mappa
            campo[coordY][coordX] = PUNTO_VUOTO;

            boolean comandoValido = true;
            switch (comando) {
                case 'L':
                    orientaSinistra();
                    System.out.println("Comando: L (Sinistra). Nuovo orientamento: " + ORIENTAMENTI_LOGICI[orientamentoCorrenteIndex]);
                    break;
                case 'R':
                    orientaDestra();
                    System.out.println("Comando: R (Destra). Nuovo orientamento: " + ORIENTAMENTI_LOGICI[orientamentoCorrenteIndex]);
                    break;
                case 'A':
                    avanza();
                    System.out.println("Comando: A (Avanti). Nuove coordinate: (" + coordX + ", " + coordY + ")");
                    break;
                default:
                    System.out.println("Comando '" + comando + "' non riconosciuto. Ignorato.");
                    comandoValido = false;
                    break;
            }

            // Riposiziona l'oggetto sulla mappa con il nuovo stato
            if (comandoValido) {
                if (!posizionaOggetto(campo, coordY, coordX, orientamentoCorrenteChar)) {
                    System.out.println("L'oggetto è uscito dai limiti della mappa!");
                    // Opzionale: puoi fermare il programma qui o gestirlo diversamente
                    // Esempio: System.out.println("Simulazione terminata."); break;
                }
            }

            // Stampa la mappa aggiornata
            stampaCampo(campo);
            System.out.println("-----------------------");

            // Pausa di un secondo
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Ripristina lo stato di interruzione
                System.out.println("Pausa interrotta.");
            }
        }

        System.out.println("\n--- Sequenza Comandi Completata ---");
        System.out.println("Posizione finale: (" + coordX + ", " + coordY + "), Orientamento: " + ORIENTAMENTI_LOGICI[orientamentoCorrenteIndex]);
        input.close();
    }

    // --- Metodi Ausiliari ---

    // Inizializza tutte le celle del campo con il carattere PUNTO_VUOTO
    private static void inizializzaCampo(char[][] campo) {
        for (int riga = 0; riga < ALTEZZA_CAMPO; riga++) {
            for (int colonna = 0; colonna < LARGHEZZA_CAMPO; colonna++) {
                campo[riga][colonna] = PUNTO_VUOTO;
            }
        }
    }

    // Posiziona l'oggetto sul campo. Ritorna false se le coordinate sono fuori limite.
    private static boolean posizionaOggetto(char[][] campo, int y, int x, char orientamento) {
        if (y >= 0 && y < ALTEZZA_CAMPO && x >= 0 && x < LARGHEZZA_CAMPO) {
            campo[y][x] = orientamento;
            return true;
        }
        return false; // Oggetto fuori dai limiti
    }

    // Stampa l'intera mappa
    private static void stampaCampo(char[][] campo) {
        // Pulisci la console (non sempre funziona su tutti i terminali Java)
        // Per Windows: new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        // Per Unix/Linux/macOS: new ProcessBuilder("clear").inheritIO().start().waitFor();
        // Alternativa: stampa molte righe vuote per "scrollare" via il contenuto precedente
        for (int k = 0; k < 50; ++k) System.out.println(); // "Pulisce" lo schermo simulando

        for (int riga = 0; riga < ALTEZZA_CAMPO; riga++) {
            for (int colonna = 0; colonna < LARGHEZZA_CAMPO; colonna++) {
                System.out.print(campo[riga][colonna]);
            }
            System.out.println();
        }
    }

    // Rotazione a sinistra (N -> O -> S -> E -> N)
    private static void orientaSinistra() {
        orientamentoCorrenteIndex = (orientamentoCorrenteIndex - 1 + ORIENTAMENTI_CHARS.length) % ORIENTAMENTI_CHARS.length;
        orientamentoCorrenteChar = ORIENTAMENTI_CHARS[orientamentoCorrenteIndex];
    }

    // Rotazione a destra (N -> E -> S -> O -> N)
    private static void orientaDestra() {
        orientamentoCorrenteIndex = (orientamentoCorrenteIndex + 1) % ORIENTAMENTI_CHARS.length;
        orientamentoCorrenteChar = ORIENTAMENTI_CHARS[orientamentoCorrenteIndex];
    }

    // Avanza di un passo in base all'orientamento attuale
    private static void avanza() {
        switch (ORIENTAMENTI_LOGICI[orientamentoCorrenteIndex]) {
            case "N": // Nord (diminuisci Y)
                coordY--;
                break;
            case "S": // Sud (aumenta Y)
                coordY++;
                break;
            case "E": // Est (aumenta X)
                coordX++;
                break;
            case "O": // Ovest (diminuisci X)
                coordX--;
                break;
        }
        // Il controllo dei limiti avviene al momento del posizionamento
    }
}