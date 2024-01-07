package algorithmsbaekjun;

import java.util.Scanner;
public class NQueensSolution {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the chessboard (N): ");
        int n = scanner.nextInt();
        scanner.close();

        int[] queens = new int[n];
        solveNQueens(queens, 0, n);
        System.out.println("Total solutions for " + n + "-queens: " + count);
    }

    private static void solveNQueens(int[] queens, int row, int n) {
        if (row == n) {
            // If all queens are placed successfully, increment the count
            count++;
            printQueens(queens);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;
                solveNQueens(queens, row + 1, n);
            }
        }
    }

    private static boolean isSafe(int[] queens, int row, int col) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queens[prevRow];
            if (prevCol == col || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false; // Check for same column or diagonal
            }
        }
        return true;
    }

    private static void printQueens(int[] queens) {
        System.out.println("\nSolution " + count + ":");
        for (int row = 0; row < queens.length; row++) {
            for (int col = 0; col < queens.length; col++) {
                if (queens[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}