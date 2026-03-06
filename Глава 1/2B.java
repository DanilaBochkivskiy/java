// Ввести с консоли n целых чисел. На консоль вывести: 2. Наибольшее и наименьшее число.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int max = sc.nextInt();
        int min = max;

        for (int i = 2; i <= n; i++) {
            int x = sc.nextInt();
            if (x > max) max = x;
            if (x < min) min = x;
        }

        System.out.println("Наибольшее: " + max);
        System.out.println("Наименьшее: " + min);
    }
}

