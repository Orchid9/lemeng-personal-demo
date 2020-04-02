package com.lemeng.personal.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户表
 */
@Entity
@Data
@Table(name = "user_info")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    @Id
    @Column(insertable = false, name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    /**
     * 专业
     */
    @Column(name = "major")
    private String major;

    /**
     * 学院
     */
    @Column(name = "Institute", nullable = false)
    private String Institute;

    /**
     * 年龄
     */
    @Column(name = "age", nullable = false)
    private Integer age = 0;

    /**
     * 性别：0-男性,1-女性
     */
    @Column(name = "sex", nullable = false)
    private Integer sex = 0;

    /**
     * 年级
     */
    @Column(name = "grade")
    private String grade;

    /**
     * 级别：0-学生，1-教师，2-教务主任
     */
    @Column(name = "level", nullable = false)
    private Integer level = 0;

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