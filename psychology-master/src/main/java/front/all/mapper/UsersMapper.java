package front.all.mapper;


import front.all.pojo.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UsersMapper {
    /**
     * 查询用户(除了管理员)
     * @return list<user></>
     */
    @Select("SELECT * FROM USER WHERE identify!=3")
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
     * @return
     */
    @Insert("insert into user(username,password,identify) values (#{user.username},#{user.password},#{user.identify})")
    public int add(@Param("user") Users user);


    /**
     * 删除指定用户
     * @param username
     * @return
     */
    @Delete("delete FROM USER WHERE username = #{username}")
    public int deletename(String username);


    /**
     * 修改用户信息
     * @param username,password,identify,name
     * @return
     */
    @Update("update user set username=#{username},password=#{password},identify=#{identify} where username=#{name}")
    public int change(@Param("username")String username,@Param("password")String password,@Param("identify")int identify,@Param("name")String name);
}
