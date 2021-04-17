package utils;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: blog
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-04 11:49
 */
public class DBUtils {
    private static MysqlDataSource dataSource=null;

    //得到connection对象
    public static Connection connection() throws SQLException {
        if (dataSource==null){
            dataSource=new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://127.0.0.1:3306/blog?characterEncoding=utf-8");
            dataSource.setUser("root");
            //dataSource.setPassword("111111");
            dataSource.setPassword("12345678");
        }
        return dataSource.getConnection();
    }

    //关闭方法
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        if (resultSet != null) resultSet.close();
        if (preparedStatement != null) preparedStatement.close();
        if (connection != null) connection.close();

    }


}
