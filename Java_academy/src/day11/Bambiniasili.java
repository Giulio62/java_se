package day11;

import java.util.*;

public class Bambiniasili {
	private static final Map<Character, String> MAPPAPIANTINE=Map.of
			('G',"Erba",'C',"TRIFOGLIO",'R',"RAVANELLO",'V',"VIOLA"); // chiave char  value String
    private static final List <String> LISTABAMBINI=
    List.of("Alice", "Bob", "Charlie", "David", "Eve", "Fred",
    		"Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry");
    private   Map< String,List <String>> MAPPABAMBINISEMI; // chiave char  value String
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
	//}

    private static final int tazze_per_bambino=2; 
    public Bambiniasili(String fila1, String fila2) {
    	
   		
    	if (fila1.length() != fila2.length() || fila1.length()%2 !=0) {
    		throw new IllegalArgumentException 
    			(")Le righe devono avere la stessa lunghezza e contenere un numero pari di tazze.");
      	}
    	this.MAPPABAMBINISEMI =new HashMap<>();// se array=String[]mappabambinisemi=new String[10]
        	
    }
    for int(i-0;i<LISTABAMBINI.sieze();i++) {
    	
    }
}
