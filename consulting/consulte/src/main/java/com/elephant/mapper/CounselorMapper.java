package com.elephant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elephant.entity.Counselor;
import org.apache.ibatis.annotations.Mapper;

/**
 * (咨询师信息表)持久层
 *
 * @author YangJian
 * @date 2022-11-06 23:16:25
 */
@Mapper
public interface CounselorMapper extends BaseMapper<Counselor> {

}