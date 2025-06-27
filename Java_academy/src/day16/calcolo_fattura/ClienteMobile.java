package day16.calcolo_fattura;

public class ClienteMobile extends Cliente {
	private int giga;
	
	
	
	public ClienteMobile(int giga) {
		super();
		this.giga = giga;
	}


	public ClienteMobile(String cf, String nome, String cognome,int giga) {
		super(cf, nome, cognome);
		this.giga = giga;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public int getGiga() {
		return giga;
	}


	public void setGiga(int giga) {
		this.giga = giga;
	}


	@Override
	public String toString() {
		return "ClienteMobile ["+ super.toString() +"giga=" + giga + "]";
	}

	
	
}
