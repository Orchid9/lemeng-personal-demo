package com.lemeng.personal.repository;

import com.lemeng.personal.dto.ScoreDTO;
import com.lemeng.personal.model.ScoreModel;
import com.lemeng.personal.model.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 学校成绩查询Dao层
 *
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
public interface StudentScoreRepository {

    /**
     * 教学处主任,教师，可以查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param academicYear 学年
     * @param subjectId    学科id
     * @return 学科平均成绩，最高分，最低分
     */
    ScoreModel readScore(@Param("academicYear") String academicYear, @Param("subjectId") Integer subjectId);

    /**
     * 查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param teacherId    教师id
     * @param academicYear 学年
     * @param subjectId    学科id
     * @return 学科平均成绩，最高分，最低分
     */
    ScoreModel findTeacherScores(@Param("teacherId") String teacherId, @Param("academicYear") String academicYear, @Param("subjectId") Integer subjectId);

    /**
     * 学生查询本人每学年各学科成绩
     *
     * @param studentId    学生id
     * @param academicYear 学年
     * @param pageNumber   页面数
     * @param pageSize     页面大小
     * @return 学生各学科成绩
     */
    List<StudentScore> findStudentScoresByStudentIdAndAcademicYear(String studentId, String academicYear, int pageNumber, int pageSize);
}