package com.lemeng.personal.repository;

import com.lemeng.personal.model.TeacherWithSubjectInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
public interface TeacherWithSubjectInfoRepository extends JpaRepository<TeacherWithSubjectInfo, Integer>, JpaSpecificationExecutor<TeacherWithSubjectInfo> {
    List<TeacherWithSubjectInfo> findTeacherWithSubjectInfosByTeacherIdIs(String teacherId);
}