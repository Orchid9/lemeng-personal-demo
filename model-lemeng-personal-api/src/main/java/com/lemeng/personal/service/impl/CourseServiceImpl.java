package com.lemeng.personal.service.impl;

import com.lemeng.personal.dto.ScoreDto;
import com.lemeng.personal.model.StudentGrade;
import com.lemeng.personal.repository.StudentGradeRepository;
import com.lemeng.personal.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private StudentGradeRepository gradeRepository;

    public ScoreDto findScores(String academic_year, Integer subject_id) {
        return gradeRepository.findScores(academic_year, subject_id);
    }

    public ScoreDto findTeacherScores(String teacher_id, String academic_year) throws InvocationTargetException, IllegalAccessException {
        ScoreDto scoreDto = new ScoreDto();
        Map<String, Object> teacherScores = gradeRepository.findTeacherScores(teacher_id, academic_year);
        BeanUtils.populate(scoreDto, teacherScores);
        return scoreDto;
    }

    public List<StudentGrade> findStudentScores(String student_id, String academic_year, int pageNumber, int pageSize) {
        Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
        return gradeRepository.findStudentGradesByStudentIdAndAcademicYear(student_id, academic_year, pageRequest);
    }
}
