package schwimmer.wordle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class WordleDictionary {

    private HashMap<String, String> words = new HashMap<>();

    public WordleDictionary() throws IOException {
        // This will load the "dictionary.txt" file from the resources directory.
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("dictionary.txt");
        if (inputStream == null) {
            throw new FileNotFoundException("dictionary.txt is not found in resources");
        }
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] entry = line.split(" ", 2);
            if (entry.length == 1) {
                words.put(entry[0], "");
            } else {
                words.put(entry[0], entry[1]);
            }
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
