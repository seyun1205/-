package front.all.mapper;

import front.all.pojo.Question;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface QuestionMapper {
    /**
     * 搜索所有题目
     * @param
     * @return list<questionbank></>
     */
    @Select("SELECT  * FROM questionbank ")
    public List<Question> selectAll();
}
