package com.lemeng.personal.controller;

import com.lemeng.personal.dto.SubjectDTO;
import com.lemeng.personal.model.Subject;
import com.lemeng.personal.service.SubjectService;
import com.nhsoft.provider.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
@Api("课程管理")
@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * 查询学科详细信息
     *
     * @param subject_id 学科id
     * @return 学科详细信息
     */
    @ApiOperation("查询学科详细信息")
    @GetMapping("nhsoft.demo.subject.read")
    public Response readSubject(@ApiParam("学科id") Integer subject_id) {
        SubjectDTO subjectDTO = new SubjectDTO();
        Subject subject = subjectService.readSubject(subject_id);
        BeanUtils.copyProperties(subject, subjectDTO);
        return Response.data(subjectDTO);
    }

    /**
     * 保存更新学科详细信息
     *
     * @param subjectDTO 学科信息
     * @return 保存更新的对象信息
     */
    @ApiOperation("保存更新学科详细信息")
    @PostMapping("nhsoft.demo.subject.save")
    public Response saveSubject(@ApiParam("学科信息") SubjectDTO subjectDTO) {
        Subject subject = new Subject();
        BeanUtils.copyProperties(subjectDTO, subject);
        return Response.data(subjectService.saveSubject(subject));
    }

    /**
     * 删除学科详细信息
     *
     * @param subject_id 学科信息
     * @return 删除结果
     */
    @ApiOperation("删除学科详细信息")
    @DeleteMapping("nhsoft.demo.subject.delete")
    public Response deleteSubject(@ApiParam("学科id") Integer subject_id) {
        subjectService.deleteSubjectById(subject_id);
        return Response.empty();
    }
}
