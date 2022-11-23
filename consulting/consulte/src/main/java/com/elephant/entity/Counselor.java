package com.elephant.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * (咨询师信息表)
 *
 * @author YangJian
 * @date 2022-11-06 23:16:25
 */
@Data
@Accessors(chain = true)
@TableName("`counselor`")
public class Counselor {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField("`user_id`")
    private Long userId;
    /**
     * 擅长方向
     */
    @TableField("`good_at`")
    private String goodAt;
    /**
     * 咨询次数
     */
    @TableField("`number_consulting`")
    private Long numberConsulting;
    /**
     * 填写信息时间
     */
    @TableField("`create_time`")
    private String createTime;

    /**
     * 自我介绍
     */
    @TableField("`introduce`")
    private String introduce;

}
