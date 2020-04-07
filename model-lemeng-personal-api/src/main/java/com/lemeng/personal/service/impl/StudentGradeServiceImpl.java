package com.lemeng.personal.service.impl;

import com.google.gson.Gson;
import com.lemeng.personal.config.SystemException;
import com.lemeng.personal.dto.ScoreDto;
import com.lemeng.personal.model.StudentGrade;
import com.lemeng.personal.model.SystemRespCode;
import com.lemeng.personal.repository.StudentGradeRepository;
import com.lemeng.personal.service.StudentGradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
@Slf4j
@Service
public class StudentGradeServiceImpl implements StudentGradeService {

    @Autowired
    private StudentGradeRepository studentGradeRepository;

    @Override
    public ScoreDto findScores(String academicYear, Integer subjectId) {
        return studentGradeRepository.findScores(academicYear, subjectId);
    }

    @Override
    public ScoreDto findTeacherScores(String teacherId, String academicYear, Integer subjectId) {
        ScoreDto teacherScores = studentGradeRepository.findTeacherScores(teacherId, academicYear, subjectId);
        return teacherScores;
    }

    @Override
    public List<StudentGrade> findStudentScores(String studentId, String academicYear, int pageNumber, int pageSize) {
        Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
        return studentGradeRepository.findStudentGradesByStudentIdAndAcademicYear(studentId, academicYear, pageRequest);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public StudentGrade saveStudentGrade(StudentGrade studentGrade) {
        StudentGrade studentGradeSave = null;
        try {
            log.info("save studentGrade is start, the param is:{}", new Gson().toJson(studentGrade));
            studentGradeSave = studentGradeRepository.save(studentGrade);
            log.info("save studentGrade is success, the param is:{}", new Gson().toJson(studentGrade));
        } catch (Exception e) {
            log.error("save studentGrade is error, the exception:{}", e);
            throw new SystemException(SystemRespCode.SAVE_ERROR);
        }
        return studentGradeSave;
    }

    @Override
    public void delStudentGradeById(Integer id) {
        studentGradeRepository.deleteById(id);
    }
}
