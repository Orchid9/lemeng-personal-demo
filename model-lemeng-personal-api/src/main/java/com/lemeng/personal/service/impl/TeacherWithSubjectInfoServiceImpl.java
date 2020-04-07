package com.lemeng.personal.service.impl;

import com.lemeng.personal.model.TeacherWithSubjectInfo;
import com.lemeng.personal.repository.TeacherWithSubjectInfoRepository;
import com.lemeng.personal.service.TeacherWithSubjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author 张九星
 * @create 2020/4/7 16:57
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class TeacherWithSubjectInfoServiceImpl implements TeacherWithSubjectInfoService {

    @Autowired
    private TeacherWithSubjectInfoRepository teacherWithSubjectInfoRepository;

    @Override
    public List<TeacherWithSubjectInfo> readTeacherWithSubjectInfo(String teacherId, int pageNumber, int pageSize) {
        Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
        return teacherWithSubjectInfoRepository.findTeacherWithSubjectInfosByTeacherIdIs(teacherId);
    }

    @Override
    public TeacherWithSubjectInfo saveTeacherWithSubjectInfo(TeacherWithSubjectInfo teacherWithSubjectInfo) {
        return teacherWithSubjectInfoRepository.save(teacherWithSubjectInfo);
    }

    @Override
    public void deleteTeacherWithSubjectInfo(Integer id) {
        teacherWithSubjectInfoRepository.deleteById(id);
    }
}
