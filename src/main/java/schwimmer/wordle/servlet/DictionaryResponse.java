package schwimmer.wordle.servlet;

/**
 * Json response from WordleDictionaryServlet
 */
public record DictionaryResponse(String word, String definition) {

}
