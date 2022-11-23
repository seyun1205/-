package com.elephant.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elephant.common.BaseResult;
import com.elephant.entity.User;
import com.elephant.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * (用户表)控制层
 *
 * @author YangJian
 * @date 2022-11-06 23:16:25
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @param user (用户表)
     * @return BaseResult
     */
    @GetMapping("/page")
    public BaseResult getUserPage(Page<User> page, User user) {
        IPage userInfo = userService.getUserInfo(page, user);
        return BaseResult.success(userInfo);
    }

    /**
     * 通过id查询(用户表)
     *
     * @param id id
     * @return BaseResult
     */
    @GetMapping("/{id}")
    public BaseResult getById(@PathVariable("id") Long id) {
        return BaseResult.success(userService.getById(id));
    }

    /**
     * 新增(用户表)
     *
     * @param user (用户表)
     * @return BaseResult
     */
    @PostMapping("/register")
    public BaseResult save(@RequestBody User user) {
        return BaseResult.success(userService.save(user));
    }

    /**
     * 修改(用户表)
     *
     * @param user (用户表)
     * @return BaseResult
     */
    @PutMapping
    public BaseResult updateById(@RequestBody User user) {
        return BaseResult.success(userService.updateById(user));
    }

    /**
     * 通过id删除(用户表)
     *
     * @param id id
     * @return BaseResult
     */
    @DeleteMapping("/{id}")
    public BaseResult removeById(@PathVariable("id") Long id) {
        return BaseResult.success(userService.removeById(id));
    }


    /**
     * 登录
     *
     * @param username
     * @param password
     * @param identify
     * @return
     */
    @GetMapping("/login")
    public BaseResult login(@RequestParam String username,
                            @RequestParam String password,
                            @RequestParam Integer identify) {
        return userService.login(username, password, identify);
    }

}
