package com.lemeng.personal.service.impl;

import com.google.gson.Gson;
import com.lemeng.personal.exception.SystemException;
import com.lemeng.personal.exception.SystemRespCode;
import com.lemeng.personal.model.ScoreModel;
import com.lemeng.personal.model.StudentScore;
import com.lemeng.personal.repository.StudentScoreRepository;
import com.lemeng.personal.service.StudentScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 学校成绩查询Service层实现
 *
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class StudentScoreServiceImpl implements StudentScoreService {

    @Autowired
    private StudentScoreRepository studentScoreRepository;

    @Override
    public ScoreModel readScore(String academicYear, Integer subjectId) {
        return studentScoreRepository.readScore(academicYear, subjectId);
    }

    @Override
    public ScoreModel readTeacherScore(String teacherId, String academicYear, Integer subjectId) {
        return studentScoreRepository.findTeacherScores(teacherId, academicYear, subjectId);
    }

    @Override
    public List<StudentScore> findStudentScores(String studentId, String academicYear, int pageNumber, int pageSize) {
        Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
        return studentScoreRepository.findStudentScoresByStudentIdAndAcademicYear(studentId, academicYear, pageRequest);
    }

    @Override
    public StudentScore saveStudentScore(StudentScore studentScore) {
        StudentScore studentScoreSave;
        try {
            log.info("save studentScore is start, the param is:{}", new Gson().toJson(studentScore));
            studentScoreSave = studentScoreRepository.save(studentScore);
            log.info("save studentScore is success, the param is:{}", new Gson().toJson(studentScore));
        } catch (Exception e) {
            log.error("save studentScore is error, the exception:{}", e);
            throw new SystemException(SystemRespCode.SAVE_ERROR);
        }
        return studentScoreSave;
    }

    @Override
    public void delStudentGradeById(Integer id) {
        studentScoreRepository.deleteById(id);
    }
}
