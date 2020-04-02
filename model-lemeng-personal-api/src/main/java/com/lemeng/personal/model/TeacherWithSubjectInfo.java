package com.lemeng.personal.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 教师授课表
 */
@Entity
@Data
@Table(name = "teacher_with_subject_info")
public class TeacherWithSubjectInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
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
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    @Column(name = "gmt_modified", nullable = false)
    private LocalDateTime gmtModified;

    
}