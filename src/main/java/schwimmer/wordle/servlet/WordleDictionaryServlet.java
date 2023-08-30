package schwimmer.wordle.servlet;

import com.google.gson.Gson;
import schwimmer.wordle.WordleDictionary;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet that looks up a word in the dictionary and returns it as a json response.
 */
public class WordleDictionaryServlet extends HttpServlet {

    private WordleDictionary dictionary = new WordleDictionary();
    private Gson gson = new Gson();

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        String word = req.getParameter("word");
        String definition = dictionary.getDefinition(word);

        DictionaryResponse dictionaryResponse = new DictionaryResponse(word, definition);
        resp.setContentType("text/json");
        resp.getWriter().println(gson.toJson(dictionaryResponse));
    }
}
