package day15;


public class Matrice2 {
    public static void main(String[] args) {

        int[][] matrix = {
            { 9, 8, 7, 2 }, // [0]
            { 5, 3, 2 },    // [1]
            { 6, 6, 7, 1, 4 } // [2] (Max length is 5)
        };

        // --- Part 1: Printing Row by Row (Your original and correct code) ---
        System.out.println("--- Printing Row by Row ---");
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[j].length; i++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }

        // --- Part 2: Attempting to print Column by Column ---
        System.out.println("-----");
        System.out.println("--- Attempting to print Column by Column ---");

        // First, find the maximum number of columns in any row
        int maxColumns = 0;
        for (int[] row : matrix) {
            if (row.length > maxColumns) {
                maxColumns = row.length;
            }
        }
        System.out.println("Max columns found: " + maxColumns);

        // Outer loop iterates through potential columns
        for (int col = 0; col < maxColumns; col++) {
            // Inner loop iterates through each row
            for (int row = 0; row < matrix.length; row++) {
                // Check if the current row has an element at the current column index
                if (col < matrix[row].length) {
                    System.out.print(matrix[row][col] + " ");
                } else {
                    // Optional: Print a placeholder or just a space if the element doesn't exist
                    System.out.print("  "); // Print two spaces to align somewhat
                }
            }
            System.out.println(); // Move to the next line after processing all rows for this column
        }
    }
}