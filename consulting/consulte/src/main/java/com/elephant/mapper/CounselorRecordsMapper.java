package com.elephant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elephant.entity.CounselorRecords;
import org.apache.ibatis.annotations.Mapper;

/**
 * (咨询记录表)持久层
 *
 * @author YangJian
 * @date 2022-11-06 23:16:25
 */
@Mapper
public interface CounselorRecordsMapper extends BaseMapper<CounselorRecords> {

}