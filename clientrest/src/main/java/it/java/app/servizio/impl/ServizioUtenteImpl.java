package it.java.app.servizio.impl;

import it.java.app.modello.*;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.java.app.modello.Data;
import it.java.app.servizio.ServizioUtente;

public class ServizioUtenteImpl implements ServizioUtente {
	public Data getUser(int id) throws Exception {
		try {
			URL url = new URL("https://reqres.in/api/users/" + id);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("x-api-key", "reqres-free-v1"); // <-- INSERISCI QUI L'HEADER PER L'API KEY
	
			connection.setDoOutput(false);
			connection.setDoInput(true);
			connection.connect();
			int responseCode = connection.getResponseCode();
			switch (responseCode) {
			case 200: {
				String contentType = connection.getContentType();
				if (contentType.contains("application/json")) {
					ObjectMapper mapper = new ObjectMapper();
					UserResponse userResponse = mapper.readValue(connection.getInputStream(), UserResponse.class);
					Data user = userResponse.getData();
					return user;
				}
			}
			case 404: {
				return null;
			}
			case 500: {
				return null;
			}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		return null;
	}

}
