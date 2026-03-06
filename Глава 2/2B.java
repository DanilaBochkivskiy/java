// 2. Вывести элементы массива в обратном порядке.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        String[] nums = new String[size];

        for (int i = 0; i <size; i++){
            nums[i] = sc.next();
        }

        for (int i = size - 1; i >= 0; i--){
            System.out.print(nums[i] + " ");
        }
    }
}
