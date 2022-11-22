package com.elephant.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.elephant.entity.CounselorRecords;

import java.util.List;

/**
 * (咨询记录表)
 *
 * @author YangJian
 * @date 2022-11-06 23:16:25
 */
public interface CounselorRecordsService extends IService<CounselorRecords> {


    List<CounselorRecords> getCounselorRecordsList(Long userId,Long counselorId);

    IPage<CounselorRecords> getCounselorRecordsPage(Page<CounselorRecords> page, CounselorRecords counselorRecords);
}
