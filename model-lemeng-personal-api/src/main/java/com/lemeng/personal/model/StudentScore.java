package com.lemeng.personal.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 学生成绩表
 *
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
@Table(name = "student_score")
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class StudentScore implements Serializable {
    private static final long serialVersionUID = 1491880369856336155L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @CreatedDate
    @Column(name = "gmt_create", updatable = false, nullable = false)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @LastModifiedDate
    private Date gmtModified;
}