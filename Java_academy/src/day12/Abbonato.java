package day12;

public class Abbonato {
	private String codiceFiscale;
	private String cognome;
	private String nome;
	
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
	
      public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    
    // Costruttore per inizializzare un oggetto Data
    public Abbonato(String codiceFiscale, String cognome, String nome) {
    	this.codiceFiscale = codiceFiscale;
    	this.cognome = cognome;
        this.nome = nome;
  
    }

    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Abbonato abbonato1 = new Abbonato("CF1", "Verdi", "Giuseppe");
        System.out.println("nuovo abbonato: "+ abbonato1.getCodiceFiscale()+" " + abbonato1.getCognome()+" " + abbonato1.getNome());

		
	}

}
