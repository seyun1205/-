package front.all.service.impl;

import front.all.mapper.QuestionMapper;
import front.all.pojo.Question;
import front.all.service.QuestionService;
import front.all.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private SqlSessionFactory sqlSessionFactory =  MybatisUtil.getSqlSessionFactory();
    @Override
    public List<Question> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        QuestionMapper mapper = sqlSession.getMapper(QuestionMapper.class);
        List<Question> questions = mapper.selectAll();
        sqlSession.close();
        return questions;
    }
}
