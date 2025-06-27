package day07.assicurazione;

public class Veicolo {

	private String targa;
	private Cliente proprietario;
	
	public Veicolo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Veicolo(String targa, Cliente proprietario) {
		super();
		this.targa = targa;
		this.proprietario = proprietario;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public Cliente getProprietario() {
		return proprietario;
	}
	public void setProprietario(Cliente proprietario) {
		this.proprietario = proprietario;
	}
	@Override
	public String toString() {
		return "Veicolo [targa=" + targa + ", proprietario=" + proprietario + "]";
	}
	

}
