<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="it.java.app.modello.Data" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dettagli Utente</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
            color: #333;
        }
        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            margin: 20px auto;
        }
        h1 {
            color: #0056b3;
            text-align: center;
            margin-bottom: 25px;
        }
        p {
            margin-bottom: 10px;
            line-height: 1.6;
        }
        strong {
            color: #555;
        }
        .user-avatar {
            display: block;
            margin: 15px auto;
            border-radius: 50%;
            border: 2px solid #ddd;
            box-shadow: 0 1px 3px rgba(0,0,0,0.1);
        }
        .error-message {
            color: red;
            font-weight: bold;
            text-align: center;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 30px;
            padding: 10px 15px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .back-link:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Dettagli Utente</h1>

        <%
            // Recupera l'oggetto "user" dalla request scope
            // Assicurati che "it.java.app.model.Data" sia il percorso completo della tua classe Data
            Data user = (Data) request.getAttribute("user");

            // Controlla se l'oggetto utente è valido prima di tentare di accedere ai suoi metodi
            if (user != null) {
        %>
                <p><strong>ID:</strong> <%= user.getId() %></p>
                <p><strong>Email:</strong> <%= user.getEmail() %></p>
                <p><strong>Nome:</strong> <%= user.getFirstName() %></p>
                <p><strong>Cognome:</strong> <%= user.getLastName() %></p>
                <p>
                    <strong>Avatar:</strong>
                    <br>
                    <img src="<%= user.getAvatar() %>" alt="User Avatar" class="user-avatar" width="150" height="150">
                </p>
        <%
            } else {
        %>
                <p class="error-message">Nessun utente trovato o errore nel recupero dei dati.</p>
                <p class="error-message">Assicurati che la servlet abbia recuperato i dati correttamente e li abbia passati alla JSP.</p>
        <%
            }
        %>

        <a href="index.jsp" class="back-link">Torna alla Home</a>
    </div>
</body>
</html>