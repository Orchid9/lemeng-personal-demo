package com.lemeng.personal.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 *
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
@Entity
@Data
@Table(name = "user_info")
@EntityListeners(AuditingEntityListener.class)
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 6204584362519578646L;

    /**
     * 学号
     */
    @Id
    private String userId;

    /**
     * 名称
     */
    private String userName;

    /**
     * 专业
     */
    private String major;

    /**
     * 学院
     */
    private String institute;

    /**
     * 年龄
     */
    private Integer age = 0;

    /**
     * 性别：0-男性,1-女性
     */
    private Integer sex = 0;

    /**
     * 年级
     */
    private String grade;

    /**
     * 级别：0-学生，1-教师，2-教务主任
     */
    private Integer level = 0;

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