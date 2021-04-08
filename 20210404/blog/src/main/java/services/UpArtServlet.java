package services;

import dao.ArticleInfoDao;
import models.ArticleInfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @program: blog
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-07 23:26
 */
@WebServlet("/upart")
public class UpArtServlet  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ=-1;
        String msg="";

        int id=Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        // 非空效验
        if (id > 0 && title != null && content != null &&
                !title.equals("") && !content.equals("")) {
            // 2.调用数据库执行相应的业务逻辑
            ArticleInfoDao articleInfoDao = new ArticleInfoDao();
            try {
                succ = articleInfoDao.upArt(id, title, content);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            msg = "无效的参数";
        }


        //打印参数
        HashMap<String, Object> map = new HashMap<>();
        map.put("succ", succ);
        map.put("msg", msg);
        ResultJSONUtils.write(response, map);
    }
}
