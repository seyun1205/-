package com.elephant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elephant.entity.Counselor;
import com.elephant.mapper.CounselorMapper;
import com.elephant.service.CounselorService;
import org.springframework.stereotype.Service;

/**
 * (咨询师信息表)业务层
 *
 * @author YangJian
 * @date 2022-11-06 23:16:25
 */
@Service
public class CounselorServiceImpl extends ServiceImpl<CounselorMapper, Counselor> implements CounselorService {

    @Override
    public Counselor getConselorByUserId(Long userId) {
        return baseMapper.selectOne(new LambdaQueryWrapper<Counselor>().eq(Counselor::getUserId, userId));
    }
}
