package day07.assicurazione;

import java.time.LocalDate;

public class Archivio {

	public static void main(String[] args) {
		
		Cliente bruno =new Cliente("Cf1", "bruno", "Rossi", LocalDate.of(1985, 6,25));
		Cliente carla =new Cliente("Cf2", "carla", "Verdi", LocalDate.of(1995, 7,15));
		Cliente rosa  =new Cliente("Cf3", "rosa", "Gialla", LocalDate.of(1965,11,5));
		System.out.println(bruno);				
		System.out.println(carla);				
		System.out.println(rosa);
		Veicolo veicolo1 = new Veicolo("Targa1", bruno);
		Veicolo veicolo2 = new Veicolo("Targa2", rosa);
		Veicolo veicolo3 = new Veicolo("Targa3", carla);
		System.out.println(veicolo1);				
		System.out.println(veicolo2);				
		System.out.println(veicolo3);				
		
		Veicolo[] archivio= {veicolo1, veicolo2, veicolo3};
		for (int i=0; i<archivio.length; i++) {
			System.out.println(archivio[i]);	
		}
		
	}
}

