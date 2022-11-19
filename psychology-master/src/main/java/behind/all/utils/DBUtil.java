package behind.all.utils;

import java.sql.*;
import java.util.Map;

public class DBUtil {
    private static String url;
    private static String userName;
    private static String password;

    /**
     * 静态块，注册驱动，因为驱动只需要主动并值注册一次即可
     */
    static{
        //获取文件对应的map对象
        Map<String,String> map = PropertiesUtil.getProperties("src//main//resources//jdbc.properties");
        try {
            Class.forName(map.get("jdbc.driverClassName"));
            url=map.get("jdbc.url");
            userName=map.get("jdbc.userName");
            password=map.get("jdbc.password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回连接对象
     * @return
     */
    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 释放资源的方法，每次finnally中只需要调用该方法即可
     * @param connection
     * @param stmt
     * @param rs
     */
    public static void closeAll(Connection connection, Statement stmt, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
