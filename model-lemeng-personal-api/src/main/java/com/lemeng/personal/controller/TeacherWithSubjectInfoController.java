package com.lemeng.personal.controller;

import com.google.common.collect.Lists;
import com.lemeng.personal.dto.TeacherWithSubjectInfoDTO;
import com.lemeng.personal.model.TeacherWithSubjectInfo;
import com.lemeng.personal.service.TeacherWithSubjectInfoService;
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

import java.util.List;

/**
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
@Api("教师学科信息")
@RestController
public class TeacherWithSubjectInfoController {


    @Autowired
    private TeacherWithSubjectInfoService teacherWithSubjectInfoService;

    /**
     * 查询教师学科信息
     *
     * @param teacherId  学科id
     * @param pageNumber 开始页
     * @param pageSize   页面数量
     * @return 教师学科信息
     */
    @ApiOperation("查询教师学科信息")
    @GetMapping("nhsoft.demo.teacher.with.subject.read")
    public Response readTeacherWithSubjectInfo(@ApiParam("教师id") String teacherId, @ApiParam("开始页") int pageNumber, @ApiParam("页面数量") int pageSize) {
        List<TeacherWithSubjectInfoDTO> teacherWithSubjectInfoDTOList = Lists.newLinkedList();
        List<TeacherWithSubjectInfo> teacherWithSubjectInfos = teacherWithSubjectInfoService.readTeacherWithSubjectInfo(teacherId, pageNumber, pageSize);
        teacherWithSubjectInfos.forEach(teacherWithSubjectInfo -> {
            TeacherWithSubjectInfoDTO teacherWithSubjectInfoDTO = new TeacherWithSubjectInfoDTO();
            BeanUtils.copyProperties(teacherWithSubjectInfo, teacherWithSubjectInfoDTO);
            teacherWithSubjectInfoDTOList.add(teacherWithSubjectInfoDTO);
        });
        return Response.data(teacherWithSubjectInfoDTOList);
    }

    /**
     * 保存更新教师学科信息
     *
     * @param teacherWithSubjectInfoDTO 教师学科信息
     * @return 保存更新的对象信息
     */
    @ApiOperation("保存更新教师学科信息")
    @PostMapping("nhsoft.demo.teacher.with.subject.save")
    public Response saveTeacherWithSubjectInfo(@ApiParam("教师学科信息") TeacherWithSubjectInfoDTO teacherWithSubjectInfoDTO) {
        TeacherWithSubjectInfo teacherWithSubjectInfo = new TeacherWithSubjectInfo();
        BeanUtils.copyProperties(teacherWithSubjectInfoDTO, teacherWithSubjectInfo);
        return Response.data(teacherWithSubjectInfoService.saveTeacherWithSubjectInfo(teacherWithSubjectInfo));
    }

    /**
     * 删除教师学科信息
     *
     * @param id 教师学科信息Id
     * @return 删除结果
     */
    @ApiOperation("删除教师学科信息")
    @DeleteMapping("nhsoft.demo.teacher.with.subject.delete")
    public Response deleteTeacherWithSubjectInfo(@ApiParam("教师学科信息Id") Integer id) {
        teacherWithSubjectInfoService.deleteTeacherWithSubjectInfo(id);
        return Response.empty();
    }
}
