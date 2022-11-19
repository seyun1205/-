package front.all.service.impl;

import front.all.mapper.CommentMapper;
import front.all.pojo.Comment;
import front.all.service.CommentService;
import front.all.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private SqlSessionFactory sqlSessionFactory =  MybatisUtil.getSqlSessionFactory();

    @Override
    public List<Comment> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
        List<Comment> comment = mapper.selectAll();
        sqlSession.close();
        return comment;
    }

    @Override
    public boolean add(Comment comment){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
        int add = mapper.add(comment);
        sqlSession.commit();
        sqlSession.close();
        return add>0;
    }
}
