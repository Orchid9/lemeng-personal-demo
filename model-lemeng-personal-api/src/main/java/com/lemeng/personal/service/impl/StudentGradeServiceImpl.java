package com.lemeng.personal.service.impl;

import com.lemeng.personal.dto.ScoreDto;
import com.lemeng.personal.model.StudentGrade;
import com.lemeng.personal.repository.StudentGradeRepository;
import com.lemeng.personal.service.StudentGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentGradeServiceImpl implements StudentGradeService {

    @Autowired
    private StudentGradeRepository studentGradeRepository;

    public ScoreDto findScores(String academicYear, Integer subjectId) {
        return studentGradeRepository.findScores(academicYear, subjectId);
    }

    public ScoreDto findTeacherScores(String teacherId, String academicYear, Integer subjectId) {
        ScoreDto teacherScores = studentGradeRepository.findTeacherScores(teacherId, academicYear, subjectId);
        return teacherScores;
    }

    public List<StudentGrade> findStudentScores(String studentId, String academicYear, int pageNumber, int pageSize) {
        Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
        return studentGradeRepository.findStudentGradesByStudentIdAndAcademicYear(studentId, academicYear, pageRequest);
    }

    @Transactional
    @Override
    public StudentGrade saveStudentGrade(StudentGrade studentGrade) {
        return studentGradeRepository.save(studentGrade);
    }

    @Override
    public void delStudentGradeById(Integer id) {
        studentGradeRepository.deleteById(id);
    }
}
