import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    //cookie 代码写入
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        //创建cookie
        Cookie usernameCookie=new Cookie("username","java");
        //设置cookie的最大存活时间
        usernameCookie.setMaxAge(60);
        //用来告诉客户端存储cookie信息的
        response.addCookie(usernameCookie);

        PrintWriter writer=response.getWriter();
        writer.println("<h1>cookie 存储成功</h1>");
    }
}
