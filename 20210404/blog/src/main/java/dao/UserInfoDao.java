package dao;

import models.UserInfo;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: blog
 * @description: 用来操作userinfo表
 * @author: FENG CHEN
 * @create: 2021-04-04 11:47
 */
public class UserInfoDao {
    //注册功能
    public int add(String username,String password) throws SQLException {
        int result=0;
        Connection connection= DBUtils.connection();
        String sql="insert into userinfo(username,password) values(?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        result=preparedStatement.executeUpdate();
        // 关闭数据库连接
        DBUtils.close(connection, preparedStatement, null);
        return result;
    }

    //查询用户
    public UserInfo getUser(String username,String password) throws SQLException {
        UserInfo userInfo = new UserInfo();
        // jdbc 查询数据库
        Connection connection = DBUtils.connection();
        String sql = "select * from userinfo where username=? and password=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        // 查询数据库
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            userInfo.setId(resultSet.getInt("id"));
            userInfo.setUsername(resultSet.getString("username"));
            userInfo.setPassword(resultSet.getString("password"));
        }
        // 关闭数据库连接
        DBUtils.close(connection, statement, resultSet);
        return userInfo;
    }
}
