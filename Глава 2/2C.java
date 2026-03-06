// 2. Выполнить циклический сдвиг заданной матрицы на k позиций вправо (влево, вверх, вниз).

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n;
                System.out.print(matrix[i][j] + "");
            }
            System.out.println();
        }

        System.out.println("Куда сдвигаем? ");
        String napr = sc.next();

        System.out.println("На сколько?");
        int k = sc.nextInt();

        for (int nomerSdviga = 0; nomerSdviga < k; nomerSdviga++) {
            if (napr.equals("vpravo")) {
                for (int i = 0; i < n; i++) {
                    int last = matrix[i][n - 1];
                    for (int j = n - 1; j > 0; j--) {
                        matrix[i][j] = matrix[i][j - 1];
                    }
                    matrix[i][0] = last;
                }
            }
            if (napr.equals("vlevo")) {
                for (int i = 0; i < n; i++) {
                    int first = matrix[i][0];
                    for (int j = 0; j < n - 1; j++) {
                        matrix[i][j] = matrix[i][j + 1];
                    }
                    matrix[i][n - 1] = first;
                }
            }
            if (napr.equals("vniz")) {
                for (int j = 0; j < n; j++) {
                    int last = matrix[n - 1][j];
                    for (int i = n - 1; i > 0; i--) {
                        matrix[i][j] = matrix[i - 1][j];
                    }
                    matrix[0][j] = last;
                }
            }
            if (napr.equals("vverh")) {
                for (int j = 0; j < n; j++) {
                    int first = matrix[0][j];
                    for (int i = 0; i < n - 1; i++) {
                        matrix[i][j] = matrix[i + 1][j];
                    }
                    matrix[n - 1][j] = first;
                }
            }
        }
        System.out.println("После сдвига:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

