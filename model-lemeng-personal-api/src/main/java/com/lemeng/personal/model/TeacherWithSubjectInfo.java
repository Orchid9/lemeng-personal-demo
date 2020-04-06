package com.lemeng.personal.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 教师授课表
 */
@Entity
@Table(name = "teacher_with_subject_info")
@Data
public class TeacherWithSubjectInfo implements Serializable {
    private static final long serialVersionUID = -3073120410400170213L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    /**
     * 教师id
     */
    @Column(name = "teacher_id", nullable = false)
    private String teacherId;

    /**
     * 课程id
     */
    @Column(name = "subject_id", nullable = false)
    private Integer subjectId;

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