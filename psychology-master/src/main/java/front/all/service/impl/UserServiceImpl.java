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
    public List<Users> getAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        List<Users> users = mapper.selectAll();
        sqlSession.close();
        return users;
    }
}
