//2. Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input = "Программирование - это круто.  Java лучшее Python! Учись прилежно.";

        String cleanText = input.replaceAll("[\\t\\s]+", " ").trim();

        List<Sentence> sentences = parseSentences(cleanText);

        sentences.sort(Comparator.comparingInt(Sentence::getWordCount));

        // 4. Вывод результата
        System.out.println("Предложения по возрастанию количества слов:");
        for (Sentence s : sentences) {
            System.out.println("[" + s.getWordCount() + " слов(а)]: " + s.getContent());
        }
    }

    private static List<Sentence> parseSentences(String text) {
        List<Sentence> list = new ArrayList<>();
        String[] rawSentences = text.split("(?<=[.!?])\\s*");

        for (String raw : rawSentences) {
            Sentence sentence = new Sentence();
            String[] tokens = raw.split("(?=[,.!?])|\\s+");
            for (String token : tokens) {
                if (token.matches("[,.!?]")) {
                    sentence.addElement(new Punctuation(token));
                } else {
                    sentence.addElement(new Word(token));
                }
            }
            list.add(sentence);
        }
        return list;
    }
}