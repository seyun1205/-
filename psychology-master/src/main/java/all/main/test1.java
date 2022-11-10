package all.main;

import all.dao.BaseDao;

import java.sql.ResultSet;

public class test1 extends BaseDao {
    public static void main(String[] args) {
        String sql="select * from user ";
        ResultSet rs=executeQuery(sql, new Object[]{});
        try{
            while(rs.next()){
                System.out.print("学号："+rs.getString(1)+"\t\t");
                System.out.print("mima："+rs.getString(2)+"\t\t");
            }
        }catch (Exception e){}
    }
}
