package com.elephant.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.elephant.common.BaseResult;
import com.elephant.entity.User;

/**
 * (用户表)
 *
 * @author YangJian
 * @date 2022-11-06 23:16:25
 */
public interface UserService extends IService<User> {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @param identify
     */
    BaseResult login(String username, String password, Integer identify);


    User getUserById(Long userId);


    IPage getUserInfo(Page<User> page, User user);

}
