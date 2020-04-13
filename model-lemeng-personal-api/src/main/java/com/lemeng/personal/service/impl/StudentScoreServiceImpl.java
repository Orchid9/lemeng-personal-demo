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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        return studentScoreRepository.findStudentScoresByStudentIdAndAcademicYear(studentId, academicYear, pageNumber, pageSize);
    }
}
