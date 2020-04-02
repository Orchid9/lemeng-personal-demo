package com.lemeng.personal.service;

import com.lemeng.personal.model.StudentGrade;

import java.util.List;
import java.util.Map;

public interface CourseService {

    /**
     * 教学处主任,教师，可以查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param academic_year 学年
     * @param subject_id    学科id
     * @return 学科平均成绩，最高分，最低分
     */
    Map<String, Object> getMaxAndMinAndAveScoresByAcaYearAndSubId(String academic_year, Integer subject_id);

    /**
     * 查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param teacher_id    教师id
     * @param academic_year 学年
     * @return 学科平均成绩，最高分，最低分
     */
    Map<String, Object> getMaxAndMinAndAveByAcaYearAndTeaId(String teacher_id, String academic_year);

    /**
     * 学生查询本人每学年各学科成绩
     *
     * @param student_id    学生id
     * @param academic_year 学年
     * @param pageNumber    开始页：0为初始页面
     * @param pageSize      页面数量
     * @return 学生各学科成绩
     */
    List<StudentGrade> getStudentQueryScores(String student_id, String academic_year, int pageNumber, int pageSize);
}
