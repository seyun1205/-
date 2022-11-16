package front.all.mapper;


import front.all.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UsersMapper {
    /**
     * 查询所有用户
     * @return list<user></>
     */
    @Select("SELECT * FROM USER")
    public List<Users> selectAll();

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Select("SELECT  * FROM USER WHERE username = #{username}")
    public Users selectUserByUsername(String username);

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into user values (#{user.username},#{user.password}")
    public void add(Users user);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    @Select("select * from user where username= #{username} and password= #{password}")
    Users select(@Param("username") String username,@Param("password") String password);
}
