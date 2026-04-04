//2. В тексте каждую букву заменить ее порядковым номером в алфавите.
//При выводе в одной строке печатать текст с двумя пробелами между буквами,
//в следующей строке внизу под каждой буквой печатать ее номер.

public class Main {
    public static void main(String[] args) {
        String text = "Привет мир";
        text = text.toUpperCase();

        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (c >= 'А' && c <= 'Я') {
                int pos = c - 'А' + 1;
                line1.append(c).append("  ");
                line2.append(pos).append(pos > 9 ? " " : "  ");
            }
        }

        System.out.println(line1.toString());
        System.out.println(line2.toString());
    }
}