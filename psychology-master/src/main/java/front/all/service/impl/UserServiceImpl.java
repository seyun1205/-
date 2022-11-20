package front.all.service.impl;


import front.all.mapper.UsersMapper;
import front.all.pojo.Users;
import front.all.service.UserService;
import front.all.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService
{
    private SqlSessionFactory sqlSessionFactory =  MybatisUtil.getSqlSessionFactory();
    @Override
    public Users getUsersByUsername(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users users = mapper.selectUserByUsername(username);
        sqlSession.close();
        return users;
    }

    @Override
    public List<Users> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        List<Users> users = mapper.selectAll();
        sqlSession.close();
        return users;
    }

    @Override
    public boolean add(Users user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        int add = mapper.add(user);
        sqlSession.commit();
        sqlSession.close();
        return add>0;
    }


    @Override
    public boolean deletename(String username){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        int delete = mapper.deletename(username);
        sqlSession.commit();
        sqlSession.close();
        return delete>0;
    }

    @Override
    public boolean change(String username,String password,int identify,String name){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        int add = mapper.change(username,password,identify,name);
        sqlSession.commit();
        sqlSession.close();
        return add>0;
    }
}
