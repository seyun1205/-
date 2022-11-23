package front.all.mapper;

import front.all.pojo.Knowledge;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface KnowledgeMapper {

    /**
     * 查询所有内容
     * @param
     * @return list<knowledge></>
     */
    @Select("SELECT  * FROM knowledge ")
    public List<Knowledge> selectAll();

    /**
     * 根据关键字查询
     * @param searchStr
     * @return
     */
    @Select("SELECT  * FROM knowledge WHERE content like '%${searchStr}%' or content_title like '%${searchStr}%'")
    public List<Knowledge> selectKnowledgeByContent(String searchStr);

    /**
     * 添加内容
     * @param
     * @return
     */
    @Insert("insert into knowledge(content_title,content) values (#{knowledge.content_title},#{knowledge.content})")
    public int addKnowledge(@Param("content_title")String content_title,@Param("content")String content);

    /**
     * 删除指定用户
     * @param content_title
     * @return
     */
    @Delete("delete FROM knowledge WHERE content_title = #{content_title}")
    public int deleteKnowledge(String content_title);

    /**
     * 修改用户信息
     * @param
     * @return
     */
    @Update("update knowledge set content_title=#{content_title},content=#{content} where content_title=#{new_title}")
    public int changeKnowledge(@Param("content_title")String content_title,@Param("content")String content,@Param("new_title")String new_title);
}
