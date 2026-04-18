//2. В каждой строке стихотворения найти и заменить заданную подстроку на подстроку иной длины.

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputPath = "input.txt";
        String outputPath = "output.txt";
        String target = "Москва, спаленная пожаром,";
        String replacement = "Слуга царю, отец солдатам…";

        Scanner sc = new Scanner(new File(inputPath));
        PrintWriter out = new PrintWriter(new File(outputPath));

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            line = line.trim().replaceAll("[\\t\\s]+", " ");

            String modifiedLine = line.replace(target, replacement);

            out.println(modifiedLine);
        }

        sc.close();
        out.close();
    }
}
