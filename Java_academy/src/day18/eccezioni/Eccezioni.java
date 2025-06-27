package day18.eccezioni;

public class Eccezioni {

	public static void main(String args[]) {
		try {
			int a = 0;
			String s = args[0];
			a = Integer.parseInt(s);
			System.out.println("a;" + a);
		} catch (NumberFormatException e) {
			System.out.println(" valore non convertibile ");
		} catch (Exception e) {
			System.out.println("se l'eccezione non viene gestita dal catch precedente, viene utilizzata questa");
		}
		System.out.println("questa frase viene sempre scritta");
		
		
	}
}
