import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * @program: servlet
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-01 20:42
 */
@MultipartConfig
public class MyUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        Part part=request.getPart("myfile");
        //全球唯一ID
        UUID uuid=UUID.randomUUID();

        //用来保存图片
        part.write(String.format("D:\\%s%S",uuid,part.getSubmittedFileName()));

        PrintWriter writer=response.getWriter();
        writer.println("上传成功");
    }


}
