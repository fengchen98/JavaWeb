package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @program: blog
 * @description: 给前端输出json数据
 * @author: FENG CHEN
 * @create: 2021-04-04 15:50
 */
public class ResultJSONUtils {
    public static void write(HttpServletResponse response, HashMap<String,Object> data) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer=response.getWriter();
        ObjectMapper mapper=new ObjectMapper();
        writer.println(mapper.writeValueAsString(data));
    }
}
