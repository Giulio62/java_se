package day_07.Biblioteca;

public class Editore {
	public String partitaIva;
	public String nome;
	public String indirizzo;
	public Editore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Editore(String partitaIva, String nome, String indirizzo) {
		super();
		this.partitaIva = partitaIva;
		this.nome = nome;
		this.indirizzo = indirizzo;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	@Override
	public String toString() {
		return "Editore [partitaIva=" + this.partitaIva + ", nome=" + this.nome + ", indirizzo=" + this.indirizzo + "]";
	}}