package com.fc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        //获得datasource
        MysqlDataSource mysqlDataSource=new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://127.0.0.1:3306/0328?useUnicode=true&characterEncoding=UTF-8");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("111111");

        //获得connection
        Connection connection=mysqlDataSource.getConnection();

        //拼接sql
        String sql="select * from student where id=?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setInt(1,2);

        //得到resultset
        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()){
            System.out.println("查询的name "+resultSet.getString("name"));
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
