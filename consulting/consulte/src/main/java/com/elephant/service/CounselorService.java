package com.elephant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elephant.entity.Counselor;

/**
 * (咨询师信息表)
 *
 * @author YangJian
 * @date 2022-11-06 23:16:25
 */
public interface CounselorService extends IService<Counselor> {

    Counselor getConselorByUserId(Long userId);

}
