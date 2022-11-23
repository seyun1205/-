package front.all.service.impl;

import front.all.mapper.KnowledgeMapper;
import front.all.pojo.Knowledge;
import front.all.service.KnowledgeService;
import front.all.utils.MybatisUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class KnowledgeServiceImpl implements KnowledgeService {
    public SqlSessionFactory sqlSessionFactory= MybatisUtil.getSqlSessionFactory();

    @Override
    public List<Knowledge> getKnowledgeByContent(String searchStr){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        KnowledgeMapper mapper=sqlSession.getMapper(KnowledgeMapper.class);
        List<Knowledge> knowledge=mapper.selectKnowledgeByContent(searchStr);
        sqlSession.close();
        return knowledge;
    }

    @Override
    public List<Knowledge> selectAll(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        KnowledgeMapper mapper=sqlSession.getMapper(KnowledgeMapper.class);
        List<Knowledge> knowledge=mapper.selectAll();
        sqlSession.close();
        return knowledge;
    }

    @Override
    public boolean addKnowledge(String content_title,String content){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        KnowledgeMapper mapper=sqlSession.getMapper(KnowledgeMapper.class);
        int add =mapper.addKnowledge(content_title,content);
        sqlSession.commit();
        sqlSession.close();
        return add>0;
    }

    @Override
    public boolean deleteKnowledge(String content_title){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        KnowledgeMapper mapper=sqlSession.getMapper(KnowledgeMapper.class);
        int delete =mapper.deleteKnowledge(content_title);
        sqlSession.commit();
        sqlSession.close();
        return delete>0;
    }

    @Override
    public boolean changeKnowledge(String content_title, String content,String new_title){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        KnowledgeMapper mapper=sqlSession.getMapper(KnowledgeMapper.class);
        int change =mapper.changeKnowledge(content_title,content,new_title);
        sqlSession.commit();
        sqlSession.close();
        return change>0;
    }
}
