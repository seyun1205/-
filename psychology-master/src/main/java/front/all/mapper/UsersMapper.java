package front.all.mapper;


import front.all.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UsersMapper {
    /**
     * 查询用户
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
     * @return
     */
    @Insert("insert into user(username,password,identify) values (#{user.username},#{user.password},#{user.identify})")
    public int add(@Param("user") Users user);


}
