package com.elephant.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elephant.common.BaseResult;
import com.elephant.entity.Counselor;
import com.elephant.service.CounselorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * (咨询师信息表)控制层
 *
 * @author YangJian
 * @date 2022-11-06 23:16:25
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/counselor")
public class CounselorController {

    private final CounselorService counselorService;

    /**
     * 分页查询
     *
     * @param page      分页对象
     * @param counselor (咨询师信息表)
     * @return BaseResult
     */
    @GetMapping("/page")
    public BaseResult getCounselorPage(Page<Counselor> page, Counselor counselor) {
        return BaseResult.success(counselorService.page(page, Wrappers.query(counselor)));
    }

    /**
     * 通过id查询(咨询师信息表)
     *
     * @param id id
     * @return BaseResult
     */
    @GetMapping("/{id}")
    public BaseResult getById(@PathVariable("id") Long id) {
        return BaseResult.success(counselorService.getById(id));
    }

    /**
     * 新增(咨询师信息表)
     *
     * @param counselor (咨询师信息表)
     * @return BaseResult
     */
    @PostMapping
    public BaseResult save(@RequestBody Counselor counselor) {
        return BaseResult.success(counselorService.save(counselor));
    }

    /**
     * 修改(咨询师信息表)
     *
     * @param counselor (咨询师信息表)
     * @return BaseResult
     */
    @PutMapping
    public BaseResult updateById(@RequestBody Counselor counselor) {
        return BaseResult.success(counselorService.updateById(counselor));
    }

    /**
     * 通过id删除(咨询师信息表)
     *
     * @param id id
     * @return BaseResult
     */
    @DeleteMapping("/{id}")
    public BaseResult removeById(@PathVariable("id") Long id) {
        return BaseResult.success(counselorService.removeById(id));
    }

    @GetMapping("/detail/{userId}")
    public BaseResult getConselorByUserId(@PathVariable Long userId) {
        return BaseResult.success(counselorService.getConselorByUserId(userId));
    }

}
