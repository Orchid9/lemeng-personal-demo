package com.lemeng.personal.dto;

import java.util.Date;

public class StudentGradeDto {

    private Integer id;

    /**
     * 学生id
     */
    private String studentId;

    /**
     * 老师id
     */
    private String teacherId;

    /**
     * 课程id
     */
    private Integer subjectId;

    /**
     * 学年
     */
    private String academicYear;

    /**
     * 分数
     */
        private Integer score;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;
}
