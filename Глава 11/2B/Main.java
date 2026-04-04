//2. Задан список целых чисел и некоторое число X. Не используя вспомогательных объектов и методов сортировки и не изменяя размера списка,
//переставить элементы списка так, чтобы сначала шли числа, не превосходящие X, а затем числа, больше X.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 3, 15, 7, 2, 20, 5};
        int x = 8;

        System.out.println("До: " + Arrays.toString(arr));

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            while (left <= right && arr[left] <= x) {
                left++;
            }
            while (left <= right && arr[right] > x) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        System.out.println("После (X = " + x + "): " + Arrays.toString(arr));
    }
}