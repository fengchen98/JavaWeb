package services;

import dao.ArticleInfoDao;
import dao.UserInfoDao;
import models.ArticleInfo;
import models.UserInfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @program: blog
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-06 21:29
 */
@WebServlet("/init")
public class InitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ=-1;
        String msg="";
        ArticleInfo articleInfo=null;

        int id=Integer.parseInt(request.getParameter("id"));
        if (id>0){
            ArticleInfoDao articleInfoDao=new ArticleInfoDao();
            try {
                articleInfo=articleInfoDao.getArtById(id);
                succ=1;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {
            msg = "无效参数";
        }


        //打印参数
        HashMap<String, Object> map = new HashMap<>();
        map.put("succ", succ);
        map.put("msg", msg);
        map.put("art",articleInfo);
        ResultJSONUtils.write(response, map);
    }
}
