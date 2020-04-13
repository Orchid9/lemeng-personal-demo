package com.lemeng.personal.repository.impl;

import com.lemeng.personal.model.ScoreModel;
import com.lemeng.personal.model.StudentScore;
import com.lemeng.personal.repository.StudentScoreRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @Author 张九星
 * @create 2020/4/13 11:07
 */
@Repository
public class StudentScoreRepositoryImpl implements StudentScoreRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ScoreModel readScore(String academicYear, Integer subjectId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ScoreModel> criteriaQuery = criteriaBuilder.createQuery(ScoreModel.class);
        Root<StudentScore> root = criteriaQuery.from(StudentScore.class);
        criteriaQuery.multiselect(
                criteriaBuilder.max(root.get("score")),
                criteriaBuilder.min(root.get("score")),
                criteriaBuilder.avg(root.get("score")));
        Predicate predicate = criteriaBuilder.and(
                criteriaBuilder.equal(root.get("academicYear"), academicYear),
                criteriaBuilder.equal(root.get("subjectId"), subjectId));
        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public ScoreModel findTeacherScores(String teacherId, String academicYear, Integer subjectId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ScoreModel> criteriaQuery = criteriaBuilder.createQuery(ScoreModel.class);
        Root<StudentScore> root = criteriaQuery.from(StudentScore.class);
        criteriaQuery.multiselect(
                criteriaBuilder.max(root.get("score")),
                criteriaBuilder.min(root.get("score")),
                criteriaBuilder.avg(root.get("score")));
        Predicate predicate = criteriaBuilder.and(
                criteriaBuilder.equal(root.get("teacherId"), teacherId),
                criteriaBuilder.equal(root.get("academicYear"), academicYear),
                criteriaBuilder.equal(root.get("subjectId"), subjectId));
        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public List<StudentScore> findStudentScoresByStudentIdAndAcademicYear(String studentId, String academicYear, int pageNumber, int pageSize) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentScore> criteriaQuery = criteriaBuilder.createQuery(StudentScore.class);
        Root<StudentScore> root = criteriaQuery.from(StudentScore.class);
        criteriaQuery.select(root);
        Predicate predicate = criteriaBuilder.and(
                criteriaBuilder.equal(root.get("studentId"), studentId),
                criteriaBuilder.equal(root.get("academicYear"), academicYear));
        criteriaQuery.where(predicate);
        // 获取分页结果集
        TypedQuery<StudentScore> query = entityManager.createQuery(criteriaQuery);
        query.setFirstResult(pageNumber * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
}
