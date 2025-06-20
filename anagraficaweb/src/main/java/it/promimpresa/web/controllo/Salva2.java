
package it.promimpresa.web.controllo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; // Importa DateTimeFormatter
import java.util.Enumeration; // Questo non serve più se commenti il doGet

import it.promimpresa.web.modello.*;
import it.promimpresa.web.persistenza.*;
import it.promimpresa.web.persistenza.impl.*;

@WebServlet("/salva2")
public class Salva2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // L'istanza del DAO dovrebbe essere singleton o gestita da un'iniezione di dipendenza,
    // ma per ora va bene così se non ci sono problemi di concorrenza.
    private static PersonaDAOImpl personaDAO = new PersonaDAOImpl();

    public Salva2() {
        super();
    }

    // --- Inizio: Questa parte l'avevi commentata, ma se un'altra servlet la esegue, eliminala da lì ---
    // Se un'altra servlet (es. FormServlet) ha un doGet simile, è lì che devi intervenire.
    // protected void doGet(HttpServletRequest request, HttpServletResponse response)
    //         throws ServletException, IOException {
    //     response.getWriter().append("Served at: ").append(request.getContextPath());
    //     response.getWriter().append(" - ContextPath : " + request.getContextPath() + "\n");
    //     // ... e tutte le altre righe che stampano info nel browser
    // }
    // --- Fine: Rimuovi da dove si trova ---

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codiceFiscale = request.getParameter("codiceFiscale");
        String nome = request.getParameter("name");
        String cognome = request.getParameter("surname");
        String dataNascitaStr = request.getParameter("dataNascita"); // Rinominato per chiarezza

        try {
            System.out.println("=== Save (Inizio) ==="); // Log inizio operazione
            System.out.println("Parametri ricevuti:");
            System.out.println("  CF: " + codiceFiscale);
            System.out.println("  Nome: " + nome);
            System.out.println("  Cognome: " + cognome);
            System.out.println("  Data Nascita (stringa dal form): " + dataNascitaStr); // DEBUG LOG

            Persona persona = new Persona();
            persona.setCF(codiceFiscale);
            persona.setNome(nome);
            persona.setCognome(cognome);

            // Parser per il formato "YYYY-MM-DDTHH:mm" generato da <input type="datetime-local">
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime dataNascita = LocalDateTime.parse(dataNascitaStr, formatter);
            persona.setDataNascita(dataNascita);

            personaDAO.save(persona);
            System.out.println("Persona salvata con successo nel database!"); // Log di successo

            // Reindirizza l'utente a una pagina di successo (es. success.jsp)
            response.sendRedirect(request.getContextPath() + "/success.jsp"); // Creerai questa JSP

        } catch (java.time.format.DateTimeParseException e) {
            // Cattura specificamente l'errore di parsing della data
            System.err.println("Errore nel parsing della data di nascita: '" + dataNascitaStr + "'");
            e.printStackTrace(); // Stampa lo stack trace completo per debugging
            // Reindirizza a una pagina di errore con un messaggio specifico
            response.sendRedirect(request.getContextPath() + "/error.jsp?msg=Formato data non valido. Inserisci data e ora nel formato corretto.");

        } catch (DAOException e) {
            // Cattura gli errori del DAO (es. problemi di DB, SQL)
            System.err.println("Ops...si è verificato un errore nel salvataggio DAO!");
            e.printStackTrace(); // FONDAMENTALE: Stampa lo stack trace completo dell'errore SQL
            // Reindirizza a una pagina di errore generica per problemi di database
            response.sendRedirect(request.getContextPath() + "/error.jsp?msg=Si è verificato un errore durante il salvataggio dei dati. Riprova più tardi.");

        } catch (Exception e) {
            // Cattura qualsiasi altra eccezione imprevista
            System.err.println("Errore generico in doPost di Salva: " + e.getMessage());
            e.printStackTrace(); // Stampa lo stack trace per altri tipi di errori
            response.sendRedirect(request.getContextPath() + "/error.jsp?msg=Si è verificato un errore imprevisto.");
        }
        System.out.println("=== Save (Fine) ==="); // Log fine operazione
    }
}