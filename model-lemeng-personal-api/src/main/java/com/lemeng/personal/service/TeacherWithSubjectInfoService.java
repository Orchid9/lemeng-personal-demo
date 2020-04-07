package com.lemeng.personal.service;

import com.lemeng.personal.model.TeacherWithSubjectInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 张九星
 * @create 2020/4/7 16:57
 */
@Repository
public interface TeacherWithSubjectInfoService {

    /**
     * 查询教师学科信息
     *
     * @param teacherId  学科id
     * @param pageNumber 开始页
     * @param pageSize   页面数量
     * @return 教师学科信息
     */
    List<TeacherWithSubjectInfo> readTeacherWithSubjectInfo(String teacherId, int pageNumber, int pageSize);

    /**
     * 保存更新教师学科信息
     *
     * @param teacherWithSubjectInfo 教师学科信息
     * @return 保存更新的对象信息
     */
    TeacherWithSubjectInfo saveTeacherWithSubjectInfo(TeacherWithSubjectInfo teacherWithSubjectInfo);

    /**
     * 删除教师学科信息
     *
     * @param id 教师学科信息Id
     */
    void deleteTeacherWithSubjectInfo(Integer id);
}