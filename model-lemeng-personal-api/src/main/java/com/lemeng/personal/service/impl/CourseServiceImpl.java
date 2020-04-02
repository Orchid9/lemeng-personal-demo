package com.lemeng.personal.service.impl;

import com.lemeng.personal.model.StudentGrade;
import com.lemeng.personal.repository.StudentGradeRepository;
import com.lemeng.personal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private StudentGradeRepository gradeRepository;

    public Map<String, Object> getMaxAndMinAndAveScoresByAcaYearAndSubId(String academic_year, Integer subject_id) {
        return gradeRepository.getMaxAndMinAndAveScoresByAcaYearAndSubId(academic_year, subject_id);
    }

    public Map<String, Object> getMaxAndMinAndAveByAcaYearAndTeaId(String teacher_id, String academic_year) {
        return gradeRepository.getMaxAndMinAndAveByAcaYearAndTeaId(teacher_id, academic_year);
    }

    public List<StudentGrade> getStudentQueryScores(String student_id, String academic_year, int pageNumber, int pageSize) {
        Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
        return gradeRepository.findStudentGradeByStudentIdAndAcademicYear(student_id, academic_year, pageRequest);
    }
}
