package schwimmer.wordle.servlet;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schwimmer.wordle.WordleDictionary;

import java.io.IOException;

/**
 * Servlet that looks up a word in the dictionary and returns it as a json response.
 */
public class WordleDictionaryServlet extends HttpServlet {

    private WordleDictionary dictionary;
    private Gson gson;

    // used in tests
    public WordleDictionaryServlet(WordleDictionary dictionary, Gson gson) {
        this.dictionary = dictionary;
        this.gson = gson;
    }

    // used in Tomcat
    public WordleDictionaryServlet() throws IOException {
        this.dictionary = new WordleDictionary();
        this.gson = new Gson();
    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws IOException {
        String word = req.getParameter("word");
        String definition = dictionary.getDefinition(word);

        DictionaryResponse dictionaryResponse = new DictionaryResponse(word, definition);
        resp.setContentType("text/json");
        resp.getWriter().println(gson.toJson(dictionaryResponse));
    }
}
