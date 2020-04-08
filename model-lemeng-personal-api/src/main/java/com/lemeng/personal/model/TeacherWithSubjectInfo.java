package com.lemeng.personal.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 教师授课表
 *
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
@Entity
@Table(name = "teacher_with_subject_info")
@Data
@EntityListeners(AuditingEntityListener.class)
public class TeacherWithSubjectInfo implements Serializable {
    private static final long serialVersionUID = -3073120410400170213L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 教师id
     */
    private String teacherId;

    /**
     * 课程id
     */
    private Integer subjectId;

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