import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: servlet
 * @description:
 * @author: FENG CHEN
 * @create: 2021-03-28 17:05
 */

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得写入流
        PrintWriter printWriter=resp.getWriter();
        printWriter.println("<h1 style='color:red'>hello servlet!!!</h1>");
    }
}
