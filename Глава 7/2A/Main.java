//2. Определить, являются ли слова анаграммами, т.е. можно ли из одного слова составить другое перестановкой букв.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] tests = {
                {"кот", "ток"}, {"сон", "нос"}, {"автор", "товар"},
                {"апельсин", "спаниель"}, {"стол", "стул"}, {"кабан", "банка"}
        };

        for (String[] test : tests) {
            String word1 = test[0];
            String word2 = test[1];
            boolean result = Anagrams(word1, word2);
            System.out.printf("\"%s\" и \"%s\" %s%n",
                    word1, word2, result ? "анаграммы " : "не анаграммы ");
        }
    }

    static boolean Anagrams(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        Arrays.sort(ca);
        Arrays.sort(cb);
        return Arrays.equals(ca, cb);
    }
}