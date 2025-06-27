package day15;

public class Matrice1 {
public static void main(String[] args) {

	int[][] matrix = { { 9, 8, 7, 2 }, // [0] --> [9,8,7]
			{ 5, 3, 2 }, // [1] --> [5,3,2]
			{ 6, 6, 7, 1, 4 } // [2] --> [6,6,7]
	}; // indici 0,1,2
	for (int j = 0; j < matrix.length; j++) {

		for (int i = 0; i < matrix[j].length; i++) {
			System.out.print(matrix[j][i] + " ");

		}

		System.out.println();
	}
	System.out.println("-----");
	// for (int k = 0; k < matrix.length; k++) {
	for (int riga = 0; riga < matrix.length; riga++) {
		System.out.println("riga = " + riga);
		for (int colonna = 0; colonna < matrix[riga].length; colonna++) {
			System.out.println("colonna = " + colonna);
			if (matrix[colonna].length > riga) {

				System.out.print(matrix[colonna][riga] + " ");
			}

		}
		System.out.println();
	}

}

}
