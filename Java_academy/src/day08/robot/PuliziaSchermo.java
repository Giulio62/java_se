package day08.robot;

public class PuliziaSchermo {

    public static void main(String[] args) {
        int numeroRighe = 50; // Numero di righe da riempire con caratteri
        int numeroColonne = 100; // Numero di colonne per righe

        // Stampare caratteri per riempire lo schermo
        for (int i = 0; i < numeroRighe; i++) {
            for (int j = 0; j < numeroColonne; j++) {
                System.out.print(" "); // Puoi usare qualsiasi carattere
            }
            System.out.println(); // Nuova riga
        }
        System.out.println("----------------------------------------------------------------------------");
    }
}