package com.lemeng.personal.repository;

import com.lemeng.personal.model.TeacherWithSubjectInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherWithSubjectInfoRepository extends JpaRepository<TeacherWithSubjectInfo, Integer>, JpaSpecificationExecutor<TeacherWithSubjectInfo> {

}