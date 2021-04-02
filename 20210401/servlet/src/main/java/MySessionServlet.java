import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: servlet
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-01 20:11
 */
public class MySessionServlet extends HelloServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        PrintWriter writer=response.getWriter();
        if (name!=null && pwd!=null && name.equals("root") && pwd.equals("root")){
            //参数为true:尝试从客户端获取session信息，如果获取不到则创建一个会话信息
            //参数为false:尝试从客户端获取session信息，如果获取不到则不会创建一个会话信息
            HttpSession session=request.getSession();
            String sessionId=session.getId();
            writer.println("<h1>欢迎访问</h1>");
            writer.println(String.format("<h3>sessionId:%s</h3>",sessionId));

            //session存储访问数量的key
            String countkey="countkey";
            if (session.isNew() || session.getAttribute(countkey)==null){
                session.setAttribute(countkey,1);
                writer.println("<h4>访问次数：1</h4>");
            }else {
                int count=(int)session.getAttribute(countkey);
                count++;
                //重新将访问数据变更到session中
                session.setAttribute(countkey,count);
                writer.println(String.format("<h3>访问次数:%s</h3>",count));

            }

        }else {
            writer.println("<h1>用户名或密码错误</h1>");
        }

    }
}
