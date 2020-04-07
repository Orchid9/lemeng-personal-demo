package com.lemeng.personal.service;

import com.lemeng.personal.model.ScoreModel;
import com.lemeng.personal.model.StudentScore;

import java.util.List;

/**
 * 学校成绩查询Service层
 *
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
public interface StudentScoreService {

    /**
     * 教学处主任,教师，可以查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param academicYear 学年
     * @param subjectId    学科id
     * @return 学科平均成绩，最高分，最低分
     */
    ScoreModel readScore(String academicYear, Integer subjectId);

    /**
     * 查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param teacherId    教师id
     * @param academicYear 学年
     * @param subjectId    学科id
     * @return 学科平均成绩，最高分，最低分
     */
    ScoreModel readTeacherScore(String teacherId, String academicYear, Integer subjectId);

    /**
     * 学生查询本人每学年各学科成绩
     *
     * @param studentId    学生id
     * @param academicYear 学年
     * @param pageNumber   开始页：0为初始页面
     * @param pageSize     页面数量
     * @return 学生各学科成绩
     */
    List<StudentScore> findStudentScores(String studentId, String academicYear, int pageNumber, int pageSize);

    /**
     * 保存学生成绩
     *
     * @param studentScore 学生成绩json对象
     * @return 保存的学生信息
     */
    StudentScore saveStudentScore(StudentScore studentScore);

    /**
     * 删除学生成绩
     *
     * @param id 学生成绩id主键
     * @return 处理结果
     */
    void delStudentGradeById(Integer id);
}
