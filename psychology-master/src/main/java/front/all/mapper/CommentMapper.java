package front.all.mapper;


import front.all.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import front.all.pojo.Comment;
import java.util.List;

public interface CommentMapper {
    /**
     * 搜索所有评论
     * @param
     * @return list<comment></>
     */
    @Select("SELECT  * FROM comment ")
    public List<Comment> selectAll();

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @Insert("insert into comment(username,nickname,content,ctime) values (#{comment.username},#{comment.nickname},#{comment.content},#{comment.ctime})")
    public int add(@Param("comment") Comment comment);
}
