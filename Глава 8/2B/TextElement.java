import java.util.ArrayList;
import java.util.List;

interface TextElement {
    String getContent();
}

class Word implements TextElement {
    private String word;
    public Word(String word) { this.word = word; }
    public String getContent() { return word; }
}

class Punctuation implements TextElement {
    private String mark;
    public Punctuation(String mark) { this.mark = mark; }
    public String getContent() { return mark; }
}

class Sentence implements TextElement {
    private List<TextElement> elements = new ArrayList<>();
    private int wordCount = 0;

    public void addElement(TextElement row) {
        elements.add(row);
        if (row instanceof Word) wordCount++;
    }

    public int getWordCount() { return wordCount; }

    public String getContent() {
        StringBuilder sb = new StringBuilder();
        for (TextElement e : elements) {
            if (e instanceof Word && sb.length() > 0) sb.append(" ");
            sb.append(e.getContent());
        }
        return sb.toString();
    }
}