// src/main/java/module-info.java (NUOVO e CORRETTO)
module com.example.demo {
    // Richiedi i moduli JavaFX che la tua applicazione usa.
    // javafx.fxml implicitamente richiede javafx.controls e javafx.graphics
    requires javafx.controls;
    requires javafx.fxml;

    // Se in futuro userai altre parti di JavaFX, aggiungi qui le relative 'requires',
    // ad esempio:
    // requires javafx.graphics; // Già incluso implicitamente da javafx.fxml
    // requires javafx.web;
    // requires javafx.media;

    // Questa riga è FONDAMENTALE: permette al modulo 'demo' di esporre il pacchetto
    // 'com.example.demo' (dove si trova MainApp) al runtime di JavaFX,
    // in modo che JavaFX possa trovare e caricare la tua applicazione.
    exports com.example.demo;
}
