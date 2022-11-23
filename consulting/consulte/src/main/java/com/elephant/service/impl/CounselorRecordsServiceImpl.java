package com.elephant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elephant.entity.CounselorRecords;
import com.elephant.mapper.CounselorRecordsMapper;
import com.elephant.service.CounselorRecordsService;
import com.elephant.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (咨询记录表)业务层
 *
 * @author YangJian
 * @date 2022-11-06 23:16:25
 */
@Service
public class CounselorRecordsServiceImpl extends ServiceImpl<CounselorRecordsMapper, CounselorRecords> implements CounselorRecordsService {

    @Resource
    private UserService userService;


    @Override
    public List<CounselorRecords> getCounselorRecordsList(Long userId, Long counselorId) {
        List<CounselorRecords> counselorRecordsList =  baseMapper.selectList(new LambdaQueryWrapper<CounselorRecords>()
                .eq(CounselorRecords::getFromUserId, userId)
                .eq(CounselorRecords::getToUserId, counselorId)
                .or(e -> e.eq(CounselorRecords::getToUserId, userId)
                        .eq(CounselorRecords::getFromUserId, counselorId)));
        for (int i = 0; i < counselorRecordsList.size(); i++) {
            CounselorRecords counselorRecords = counselorRecordsList.get(i);
            counselorRecords.setToUser(userService.getUserById(counselorRecords.getToUserId()));
            counselorRecords.setFromUser(userService.getUserById(counselorRecords.getFromUserId()));
        }
        return counselorRecordsList;
    }

    @Override
    public IPage<CounselorRecords> getCounselorRecordsPage(Page<CounselorRecords> page, CounselorRecords counselorRecords) {
        Page<CounselorRecords> page1 = baseMapper.selectPage(page, null);
        List<CounselorRecords> records = page1.getRecords();
        for (int i = 0; i < records.size(); i++) {
            CounselorRecords counselorRecords1 = records.get(i);
            counselorRecords1.setToUser(userService.getUserById(counselorRecords1.getToUserId()));
            counselorRecords1.setFromUser(userService.getUserById(counselorRecords1.getFromUserId()));
        }
        return page1;
    }


}
