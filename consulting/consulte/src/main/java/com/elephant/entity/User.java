package com.elephant.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * (用户表)
 *
 * @author YangJian
 * @date 2022-11-06 23:16:25
 */
@Data
@Accessors(chain = true)
@TableName("`user`")
public class User {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    @TableField("`username`")
    private String username;
    /**
     * 密码
     */
    @TableField("`password`")
    private String password;



    @TableField("`identify`")
    private Integer identify;

    /**
     * 关联信息
     */
    @TableField(exist = false)
    private Counselor counselor;


}
