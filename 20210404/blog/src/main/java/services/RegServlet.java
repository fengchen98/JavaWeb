package services;

import dao.UserInfoDao;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/json");
        int succ=0;
        String msg="";

        //1.获得参数
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        // 2.操作数据库添加用户
        UserInfoDao userInfoDao = new UserInfoDao();
        try {
            succ = userInfoDao.add(username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        // 3.返回结果
//        PrintWriter writer = response.getWriter();
//        // {"succ":1,"msg":"msg"}
//        writer.println(String.format("{\"succ\":%d,\"msg\":\"%s\"}",
//                succ, msg));
        HashMap<String,Object> map = new HashMap<>();
        map.put("succ",succ);
        map.put("msg",msg);
        ResultJSONUtils.write(response,map);
    }
}
