package all.dao;

import all.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

    /**
     * 执行DML的方法
     * @param sql  执行的sql
     * @param params  参数
     */
    public int executeUpdate(String sql,Object[] params){
        Connection connection = DBUtil.getConnection();
        int result=-1;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            //判断是否有参数
            if(params!=null){
                //有参数，就需要给参数赋值
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i+1,params[i]);
                }

            }
            //执行
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 执行DQL的方法
     * @param sql
     * @param params
     * @return
     */
    public static ResultSet executeQuery(String sql, Object[] params){
        Connection connection = DBUtil.getConnection();
        ResultSet rs=null;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            //判断是否有参数
            if(params!=null){
                //有参数，就需要给参数赋值
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i+1,params[i]);
                }

            }
            //执行
            rs=pstmt.executeQuery();
            //
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }


}
