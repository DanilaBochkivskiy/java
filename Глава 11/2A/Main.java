//2. Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.print("Введите число: ");
        int n = in.nextInt();

        if (n == 0) stack.push(0);

        while (n > 0) {
            stack.push(n % 10);
            n /= 10;
        }

        System.out.print("Результат: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}