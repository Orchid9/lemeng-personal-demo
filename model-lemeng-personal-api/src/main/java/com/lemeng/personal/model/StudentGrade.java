package com.lemeng.personal.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 学生成绩表
 */
@Table(name = "student_grade")
@Data
@Entity
public class StudentGrade implements Serializable {
    private static final long serialVersionUID = 1491880369856336155L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    /**
     * 学生id
     */
    @Column(name = "student_id", nullable = false)
    private String studentId;

    /**
     * 老师id
     */
    @Column(name = "teacher_id", nullable = false)
    private String teacherId;

    /**
     * 课程id
     */
    @Column(name = "subject_id", nullable = false)
    private Integer subjectId;

    /**
     * 学年
     */
    @Column(name = "academic_year", nullable = false)
    private String academicYear;

    /**
     * 分数
     */
    @Column(name = "score", nullable = false)
    private Integer score;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create", nullable = false)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @Column(name = "gmt_modified", nullable = false)
    private Date gmtModified;

}