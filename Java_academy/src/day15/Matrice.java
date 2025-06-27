package day15;

public class Matrice {

	public static void main(String[] args) {
		int[][] matrix = { { 9, 8, 7 }, { 5, 3, 2 }, { 6, 6, 7 } };
		for (int j = 0; j < matrix.length; j++) {
			for (int i = 0; i < matrix[j].length; i++) {
				System.out.print(matrix[j][i] + " ");
			}
			System.out.println();
		}
		System.out.println("---");
		for (int k=0; k< matrix.length;k++) {
			for (int x=0; x< matrix.length;x++) {
			System.out.println(matrix[x][k]+"");
		}
		System.out.println();
	}

}
