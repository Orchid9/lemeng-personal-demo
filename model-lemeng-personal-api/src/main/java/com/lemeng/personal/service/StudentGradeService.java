package com.lemeng.personal.service;

import com.lemeng.personal.dto.ScoreDto;
import com.lemeng.personal.model.StudentGrade;

import java.util.List;

public interface StudentGradeService {

    /**
     * 教学处主任,教师，可以查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param academic_year 学年
     * @param subject_id    学科id
     * @return 学科平均成绩，最高分，最低分
     */
    ScoreDto findScores(String academic_year, Integer subject_id);

    /**
     * 查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param teacherId    教师id
     * @param academicYear 学年
     * @param subjectId    学科id
     * @return 学科平均成绩，最高分，最低分
     */
    ScoreDto findTeacherScores(String teacherId, String academicYear, Integer subjectId);

    /**
     * 学生查询本人每学年各学科成绩
     *
     * @param teacherId    学生id
     * @param academicYear 学年
     * @param pageNumber   开始页：0为初始页面
     * @param pageSize     页面数量
     * @return 学生各学科成绩
     */
    List<StudentGrade> findStudentScores(String teacherId, String academicYear, int pageNumber, int pageSize);

    /**
     * 保存学生成绩
     *
     * @param studentGrade 学生成绩json对象
     * @return 保存的学生信息
     */
    StudentGrade saveStudentGrade(StudentGrade studentGrade);

    /**
     * 删除学生成绩
     *
     * @param id 学生成绩id主键
     * @return 处理结果
     */
    void delStudentGradeById(Integer id);
}
