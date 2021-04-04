package services;

import dao.UserInfoDao;
import models.UserInfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ=-1;
        String msg="";

        String username=request.getParameter("username");
        String password=request.getParameter("password");

        if (username!=null && !username.equals("") && password != null && !password.equals("")){
            UserInfoDao userInfoDao=new UserInfoDao();
            try {
                UserInfo userInfo=userInfoDao.getUser(username,password);
                if (userInfo.getId() > 0) {
                    // 查到用户了，也就是用户名和密码是正确
                    succ = 1;
                    //将用户信息存放到session
                    HttpSession session=request.getSession();//用来创建会话
                    //将用户信息存放到session中
                    session.setAttribute("userinfo",userInfo);

                } else {
                    succ = 0;
                    msg = "用户名或密码输出错误！";
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else {
            msg = "非法请求，参数不完整";
        }

        //打印参数
        HashMap<String, Object> map = new HashMap<>();
        map.put("succ", succ);
        map.put("msg", msg);
        ResultJSONUtils.write(response, map);
    }
}
