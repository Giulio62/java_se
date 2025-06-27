package day16.calcolo_fattura;
import java.math.BigDecimal;


public class FatturaTest {	public static void main(String[] args) {		
	 	
		ClienteGas gianlucaVacchi = new ClienteGas( " cf2","gianluca","vacchi",50.00);
		ClienteLuce paolorossi = new ClienteLuce("cf2","paolo","rossi",80.00);
		ClienteFisso marianeri = new ClienteFisso( "cf3","maria","neri",ContrattoFisso.SPECIAL );
		FatturaController.calcoloFattura(marianeri); 
		FatturaController.calcoloFattura(paolorossi); 
		System.out.println(marianeri.toString());
		System.out.println(paolorossi.toString());
		System.out.println(gianlucaVacchi.toString());
		
	}}