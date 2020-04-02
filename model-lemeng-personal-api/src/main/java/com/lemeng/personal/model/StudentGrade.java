package com.lemeng.personal.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 学生成绩表
 */
@Data
@Entity
@Table(name = "student_grade")
public class StudentGrade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
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
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    @Column(name = "gmt_modified", nullable = false)
    private LocalDateTime gmtModified;

    
}