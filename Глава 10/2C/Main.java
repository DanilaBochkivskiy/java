//2. Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File outputDir = new File("output_result");
        File outputFile = new File(outputDir, "ModifiedClass.java");

        File inputFile = new File("src/newyear/Sweet.java");

        try {
            if (!outputDir.exists()) {
                if (outputDir.mkdir()) {
                    System.out.println("Директория создана: " + outputDir.getName());
                }
            }

            if (!inputFile.exists()) {
                System.out.println("Входной файл не найден! Проверьте путь.");
                return;
            }

            StringBuilder content = new StringBuilder();
            try (Scanner scanner = new Scanner(inputFile)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String modifiedLine = line.replaceAll("\\bpublic\\b", "private");
                    content.append(modifiedLine).append(System.lineSeparator());
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write(content.toString());
            }

            System.out.println("Обработка завершена.");
            System.out.println("Результат сохранен в: " + outputFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}