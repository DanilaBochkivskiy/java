// 2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String[] nums = new String[size];
        for (int i = 0; i < size; i++) {
            nums[i] = sc.next();
        }
        String[] numsClone = nums.clone();
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j + 1].length() < nums[j].length()) {
                    String swap = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = swap;
                }
            }
        }
        for (int i = 1; i < numsClone.length; i++) {
            for (int j = 0; j < numsClone.length - i; j++) {
                if (numsClone[j + 1].length() > numsClone[j].length()) {
                    String swap = numsClone[j];
                    numsClone[j] = numsClone[j + 1];
                    numsClone[j + 1] = swap;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        for (int i = 0; i < numsClone.length; i++) {
            System.out.println(numsClone[i]);
        }
    }
}
