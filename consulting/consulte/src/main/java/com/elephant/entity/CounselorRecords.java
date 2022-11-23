package com.elephant.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * (咨询记录表)
 *
 * @author YangJian
 * @date 2022-11-06 23:16:25
 */
@Data
@Accessors(chain = true)
@TableName("`counselor_records`")
public class CounselorRecords {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 消息发起方
     */
    @TableField("`from_user_id`")
    private Long fromUserId;
    /**
     * 消息接收方
     */
    @TableField("`to_user_id`")
    private Long toUserId;
    /**
     * 消息体
     */
    @TableField("`message`")
    private String message;
    /**
     * 发送时间
     */
    @TableField("`create_time`")
    private String createTime;

    @TableField(exist = false)
    private User fromUser;

    @TableField(exist = false)
    private User toUser;

}
