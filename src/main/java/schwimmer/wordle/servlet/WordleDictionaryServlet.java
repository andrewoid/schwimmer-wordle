package schwimmer.wordle.servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schwimmer.wordle.WordleDictionary;

import java.io.IOException;

/**
 * Servlet that looks up a word in the dictionary and returns it as a json response.
 */
public class WordleDictionaryServlet extends HttpServlet {

    private WordleDictionary dictionary = new WordleDictionary();
    private Gson gson = new Gson();

    public WordleDictionaryServlet() throws IOException {
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
