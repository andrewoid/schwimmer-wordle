package schwimmer.wordle.servlet;

/**
 * Json response from WordleDictionaryServlet
 * @param word
 * @param definition
 */
public record DictionaryResponse(String word, String definition) {

}
