//2. Текст из n2 символов шифруется по следующему правилу:
//— все символы текста записываются в квадратную таблицу размерности
//n в порядке слева направо, сверху вниз;
//— таблица поворачивается на 90° по часовой стрелке;
//— 1я строка таблицы меняется местами с последней, 2я — с предпоследней и т.д.;
//— 1й столбец таблицы меняется местами со 2м, 3й — с 4м и т.д.;
//— зашифрованный текст получается в результате обхода результирующей
//таблицы по спирали по часовой стрелке, начиная с левого верхнего угла.
//Зашифровать текст по указанному правилу.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input = "ПРОГРАММИРОВАНИЕ"; // 16 символов, n=4
        int n = (int) Math.sqrt(input.length());
        char[][] matrix = new char[n][n];

        int k = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = input.charAt(k++);

        matrix = povorot90(matrix, n);

        for (int i = 0; i < n / 2; i++) {
            char[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }

        for (int j = 0; j < n - 1; j += 2) {
            for (int i = 0; i < n; i++) {
                char temp = matrix[i][j];
                matrix[i][j] = matrix[i][j + 1];
                matrix[i][j + 1] = temp;
            }
        }

        System.out.print("Зашифрованный текст: ");
        printSpiral(matrix, n);
    }

    static char[][] povorot90(char[][] m, int n) {
        char[][] res = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                res[j][n - 1 - i] = m[i][j];
        return res;
    }

    static void printSpiral(char[][] m, int n) {
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) System.out.print(m[top][i]);
            top++;
            for (int i = top; i <= bottom; i++) System.out.print(m[i][right]);
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) System.out.print(m[bottom][i]);
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) System.out.print(m[i][left]);
                left++;
            }
        }
    }
}