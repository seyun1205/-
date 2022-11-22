package com.elephant.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elephant.common.BaseResult;
import com.elephant.entity.CounselorRecords;
import com.elephant.service.CounselorRecordsService;
import com.elephant.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (咨询记录表)控制层
 *
 * @author YangJian
 * @date 2022-11-06 23:16:25
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/counselorRecords")
public class CounselorRecordsController {

    private final CounselorRecordsService counselorRecordsService;

    private final UserService userService;

    /**
     * 分页查询
     *
     * @param page             分页对象
     * @param counselorRecords (咨询记录表)
     * @return BaseResult
     */
    @GetMapping("/page")
    public BaseResult getCounselorRecordsPage(Page<CounselorRecords> page, CounselorRecords counselorRecords) {
        return BaseResult.success(counselorRecordsService.getCounselorRecordsPage(page,counselorRecords));
    }

    /**
     * 通过id查询(咨询记录表)
     *
     * @param id id
     * @return BaseResult
     */
    @GetMapping("/{id}")
    public BaseResult getById(@PathVariable("id") Long id) {
        return BaseResult.success(counselorRecordsService.getById(id));
    }

    /**
     * 新增(咨询记录表)
     *
     * @param counselorRecords (咨询记录表)
     * @return BaseResult
     */
    @PostMapping
    public BaseResult save(@RequestBody CounselorRecords counselorRecords) {
        return BaseResult.success(counselorRecordsService.save(counselorRecords));
    }

    /**
     * 修改(咨询记录表)
     *
     * @param counselorRecords (咨询记录表)
     * @return BaseResult
     */
    @PutMapping
    public BaseResult updateById(@RequestBody CounselorRecords counselorRecords) {
        return BaseResult.success(counselorRecordsService.updateById(counselorRecords));
    }

    /**
     * 通过id删除(咨询记录表)
     *
     * @param id id
     * @return BaseResult
     */
    @DeleteMapping("/{id}")
    public BaseResult removeById(@PathVariable("id") Long id) {
        return BaseResult.success(counselorRecordsService.removeById(id));
    }

    @GetMapping("/getCounselorRecordsList/{userId}/{counselorId}")
    public BaseResult getCounselorRecordsList(@PathVariable("counselorId") Long counselorId,
                                              @PathVariable("userId") Long userId) {
        return BaseResult.success(counselorRecordsService.getCounselorRecordsList(userId, counselorId));
    }

}
