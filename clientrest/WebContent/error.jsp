<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Si è verificato un errore</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f8d7da; /* Light red background for error */
            color: #721c24; /* Dark red text */
            border: 1px solid #f5c6cb;
            padding: 20px;
            border-radius: 5px;
            max-width: 600px;
            margin: 20px auto;
        }
        h1 {
            color: #721c24;
            text-align: center;
        }
        p {
            text-align: center;
        }
        .error-details {
            background-color: #fceceb;
            border: 1px solid #f5c6cb;
            padding: 15px;
            margin-top: 20px;
            border-radius: 5px;
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
        <h1>Ops! Si è verificato un errore.</h1>
        <p>Siamo spiacenti, qualcosa è andato storto durante l'elaborazione della tua richiesta.</p>

        <div class="error-details">
            <p><strong>Dettagli:</strong></p>
            <%-- Recupera il messaggio di errore dalla richiesta --%>
            <%
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null && !errorMessage.isEmpty()) {
            %>
                    <p><%= errorMessage %></p>
            <%
                } else {
            %>
                    <p>Nessun dettaglio specifico dell'errore disponibile.</p>
            <%
                }
            %>
        </div>
        <a href="index.jsp" class="back-link">Torna alla Home</a>
    </div>
</body>
</html>