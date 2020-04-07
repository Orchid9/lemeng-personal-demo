package com.lemeng.personal.repository;

import com.lemeng.personal.dto.ScoreDTO;
import com.lemeng.personal.model.ScoreModel;
import com.lemeng.personal.model.StudentScore;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 学校成绩查询Dao层
 *
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
public interface StudentScoreRepository extends JpaRepository<StudentScore, Integer>, JpaSpecificationExecutor<ScoreDTO> {

    /**
     * 教学处主任,教师，可以查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param academicYear 学年
     * @param subjectId    学科id
     * @return 学科平均成绩，最高分，最低分
     */
    @Query(value = "SELECT new com.lemeng.personal.model.ScoreModel(MAX(sg.score), MIN(sg.score) ,AVG(sg.score))" +
            "from StudentScore sg " +
            "WHERE sg.academicYear = :academicYear AND sg.subjectId = :subjectId")
    ScoreModel readScore(@Param("academicYear") String academicYear, @Param("subjectId") Integer subjectId);

    /**
     * 查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param teacherId    教师id
     * @param academicYear 学年
     * @param subjectId    学科id
     * @return 学科平均成绩，最高分，最低分
     */
    @Query(value = "SELECT new com.lemeng.personal.model.ScoreModel(MAX(sg.score), MIN(sg.score) ,AVG(sg.score))" +
            "from StudentScore sg " +
            "WHERE sg.teacherId = :teacherId AND sg.academicYear = :academicYear AND sg.subjectId = :subjectId")
    ScoreModel findTeacherScores(@Param("teacherId") String teacherId, @Param("academicYear") String academicYear, @Param("subjectId") Integer subjectId);

    /**
     * 学生查询本人每学年各学科成绩
     *
     * @param studentId    学生id
     * @param academicYear 学年
     * @param pageRequest  页面请求配置
     * @return 学生各学科成绩
     */
    List<StudentScore> findStudentScoresByStudentIdAndAcademicYear(String studentId, String academicYear, Pageable pageRequest);
}