package it.java.app.controllo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.java.app.modello.Data; // Assicurati che questo import sia corretto
import it.java.app.servizio.impl.ServizioUtenteImpl;
import it.java.app.servizio.ServizioUtente;

@WebServlet("/servizioutente")
public class ServizioUtenteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServizioUtenteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServizioUtente servizioUtente = new ServizioUtenteImpl();
        // int index = Integer.parseInt(request.getParameter("id")); // Old line

        int index = -1; // Initialize to an invalid value
        String idParam = request.getParameter("id"); // Get the parameter as a String

        try {
            // Check if idParam is null or empty first
            if (idParam == null || idParam.isEmpty()) {
                System.out.println("DEBUG: ID parameter is missing or empty.");
                request.setAttribute("errorMessage", "Il parametro 'id' è mancante o vuoto. Utilizzare ad esempio: /servizioutente?id=3");
                request.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
                return; // Stop further execution in this method
            }

            // Attempt to parse the integer
            index = Integer.parseInt(idParam);
            System.out.println("index: " + index);

            Data user = servizioUtente.getUser(index);
            System.out.println("Utente proveniente dalla API rest " + user);

            request.setAttribute("user", user); // Ensure this matches your JSP's expectation (user or utente)
            System.out.println("sto per richiamare la visualizza.jsp");
            request.getServletContext().getRequestDispatcher("/visualizza.jsp").forward(request, response);

        // Catch NumberFormatException specifically
        } catch (NumberFormatException e) {
            System.out.println("Ops...si è verificato un errore: ID non valido o non numerico: " + idParam);
            e.printStackTrace();
            request.setAttribute("errorMessage", "ID utente non valido. Assicurati di passare un numero intero (es. ?id=3).");
            request.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        // Catch other general exceptions (e.g., problems with the API call itself)
        } catch (Exception e) {
            System.out.println("Ops...si è verificato un errore generico nel recupero dell'utente: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("errorMessage", "Si è verificato un errore inatteso nel recupero dell'utente: " + e.getMessage());
            request.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}