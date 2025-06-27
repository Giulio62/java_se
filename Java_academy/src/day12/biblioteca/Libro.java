package day12.biblioteca;

import java.util.HashMap;
import java.time.LocalTime;;

public class Libro {
	public String isbn;
	public String titolo;
	public HashMap<String, Boolean> autori;
	public Editore casaeditrice;

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Libro(String isbn, String titolo, HashMap<String, Boolean> autori, Editore casaeditrice) {
		super();
		this.isbn = isbn;
		this.titolo = titolo;
		this.autori = autori;
		this.casaeditrice = casaeditrice;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public HashMap<String, Boolean> getAutori() {
		return autori;
	}

	public void setAutori(HashMap<String, Boolean> autori) {
		this.autori = autori;
	}

	public Editore getCasaeditrice() {
		return casaeditrice;
	}

	public void setCasaeditrice(Editore casaeditrice) {
		this.casaeditrice = casaeditrice;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + this.isbn + ", titolo=" + this.titolo + ", autori=" + this.autori + ", casaeditrice="
				+ this.casaeditrice + "]";
	}
}