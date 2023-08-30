package schwimmer.wordle;

import org.junit.jupiter.api.Test;
import schwimmer.wordle.WordleDictionary;

import static org.junit.jupiter.api.Assertions.*;

class WordleDictionaryTest {

    @Test
    void isWord() {
        // given
        WordleDictionary dictionary = new WordleDictionary();

        // when

        // then
        assertTrue(dictionary.isWord("party"));
    }

    @Test
    void getDefinition() {
        // given
        WordleDictionary dictionary = new WordleDictionary();

        // when

        // then
        assertEquals(
                "to attend a social gathering [v -TIED, -TYING, -TIES]",
                dictionary.getDefinition("party"));
    }
}