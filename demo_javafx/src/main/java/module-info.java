module demo.javafx {
    requires javafx.controls; // Richiede il modulo JavaFX per i controlli UI (Button, Label, TextField)
    requires javafx.fxml; // Richiede il modulo FXML (anche se non lo usiamo direttamente in questa demo, è una dipendenza comune per progetti JavaFX)

    exports com.example.demo; // Esporta il pacchetto 'com.example.demo' per renderlo accessibile
}