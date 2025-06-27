package day07.assicurazione;

import java.time.LocalDate;

public class Cliente {
      private String codiceFiscale;
	  private String nome;
	  private String cognome;
	  private LocalDate nascita;
	  
	  
      public Cliente(String codiceFiscale, String nome, String cognome, LocalDate nascita) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.nascita = nascita;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getNascita() {
		return nascita;
	}

	public void setNascita(LocalDate nascita) {
		this.nascita = nascita;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Cliente [codiceFiscale=" + codiceFiscale + ", nome=" + nome + ", cognome=" + cognome + ", nascita="
				+ nascita + "]";
	}

}
