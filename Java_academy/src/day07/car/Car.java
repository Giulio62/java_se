package day07.car;

public class Car {
	private String targa;
	private String marca;
	private String modello;
	private double fuel;
	private double consumoMedio;

	public Car() {
		super();
	} // Costruttore di default

	public Car(String targa, String marca, String modello, double fuel, double consumoMedio) {
		super();
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
		this.fuel = fuel;
		this.consumoMedio = consumoMedio;
	}

	// --- Getters ---
	public String getTarga() {
		return this.targa;
	}

	public String getMarca() {
		return this.marca;
	}

	public String getModello() {
		return this.modello;
	}

	public double getFuel() {
		return this.fuel;
	}

	public double getConsumoMedio() {
		return this.consumoMedio;
	}

	// --- Setters ---
	public void setTarga(String targa) {
		this.targa = targa;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	public void setConsumoMedio(double consumoMedio) {
		this.consumoMedio = consumoMedio;
	}

	// --- toString() Method ---
	@Override
	public String toString() {
		return "Car [Targa=" + targa + ", Marca=" + marca + ", Modello=" + modello + ", Fuel=" + fuel
				+ ", Consumo Medio=" + consumoMedio + "]";
	}
}