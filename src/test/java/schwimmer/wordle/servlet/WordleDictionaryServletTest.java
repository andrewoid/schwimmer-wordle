package schwimmer.wordle.servlet;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import schwimmer.wordle.WordleDictionary;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;

public class WordleDictionaryServletTest {

    @Test
    public void doGet() throws ServletException, IOException {
        // given
        WordleDictionary dictionary = mock();
        doReturn("Parties are fun").when(dictionary).getDefinition("party");
        Gson gson = new Gson();
        WordleDictionaryServlet servlet = new WordleDictionaryServlet(dictionary, gson);
        HttpServletRequest request = mock();
        doReturn("party").when(request).getParameter("word");

        HttpServletResponse response = mock();
        PrintWriter out = mock();
        doReturn(out).when(response).getWriter();

        // when
        servlet.doGet(request, response);

        // then
        verify(response).setContentType("text/json");
        verify(out).println(anyString());
    }
}