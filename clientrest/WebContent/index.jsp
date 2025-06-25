<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Form ID</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 20px;
	background-color: #f4f4f4;
}

.container {
	background-color: #fff;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	max-width: 400px;
	margin: auto;
}

label {
	display: block;
	margin-bottom: 8px;
	font-weight: bold;
}

input[type="text"] {
	width: calc(100% - 20px);
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ddd;
	border-radius: 4px;
	box-sizing: border-box; /* Include padding in the width */
}

input[type="submit"] {
	background-color: #007bff;
	color: white;
	padding: 10px 15px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}

.error-message {
	color: red;
	font-size: 0.9em;
	margin-top: -15px;
	margin-bottom: 15px;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Inserisci il tuo ID</h2>
	<form id="idForm" action="<%=request.getContextPath() + "/servizioutente" %>" method="get">	
			<label for="idInput">ID:</label> <input type="text" id="idInput"
				name="id" placeholder="Inserisci il tuo ID" required>
			<div id="idError" class="error-message">Quì viene scritto il
				messaggio di errore</div>
			<input type="submit" value="Invia">
		</form>
	</div>
	<script>
		document
				.getElementById('idForm')
				.addEventListener(
						'submit',
						function(event) {
							const idInput = document.getElementById('idInput');
							const idError = document.getElementById('idError');
							const idValue = idInput.value.trim();

							// Esempio di validazione: l'ID deve essere numerico e di 5 cifre
							const idPattern = /^\d$/;

							if (!idPattern.test(idValue)) {
								idError.textContent = 'L\'ID deve essere numerico e di 5 cifre.';
								event.preventDefault(); // Impedisce l'invio del form
							} else {
								idError.textContent = ''; // Cancella il messaggio di errore
								// Qui potresti inviare il form o elaborare l'ID
								alert('ID inserito: ' + idValue); // Solo per dimostrazione
							}
						});
	</script>
</body>
</html>