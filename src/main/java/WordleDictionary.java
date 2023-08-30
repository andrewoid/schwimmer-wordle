import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class WordleDictionary {

    private HashMap<String, String> words = new HashMap<>();

    public WordleDictionary() {
        File file = new File("dictionary.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] entry = line.split(" ", 2);
                if (entry.length == 1) {
                    words.put(entry[0], "");
                } else {
                    words.put(entry[0], entry[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isWord(final String lookupWord) {
        return getDefinition(lookupWord) != null;
    }

    public String getDefinition(String lookupWord) {
        String lookupWordUpperCase = lookupWord.toUpperCase();
        return words.get(lookupWordUpperCase);
    }

}
