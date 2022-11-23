package com.elephant.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elephant.common.BaseResult;
import com.elephant.entity.Counselor;
import com.elephant.entity.User;
import com.elephant.mapper.CounselorMapper;
import com.elephant.mapper.UserMapper;
import com.elephant.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (用户表)业务层
 *
 * @author YangJian
 * @date 2022-11-06 23:16:25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private CounselorMapper counselorMapper;



    @Override
    public BaseResult login(String username, String password, Integer identify) {
        List<User> users = baseMapper.selectList(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username)
                .eq(User::getIdentify,identify));
        for (User user : users) {
            if (password.equals(user.getPassword())) {
                return BaseResult.success(user);
            }
        }
        return BaseResult.fail("账号或者密码不正确");
    }

    @Override
    public User getUserById(Long userId) {
        return baseMapper.selectById(userId);
    }

    @Override
    public IPage getUserInfo(Page<User> page, User user) {
        Page<User> page1 = this.page(page, Wrappers.query(user));
        List<User> userList = page1.getRecords();
        for (User value : userList) {
            value.setCounselor(counselorMapper.selectOne(new LambdaQueryWrapper<Counselor>()
                    .eq(Counselor::getUserId, value.getId())));
        }
        return page1;
    }
}
