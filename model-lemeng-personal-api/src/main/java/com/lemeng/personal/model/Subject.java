package com.lemeng.personal.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * 课程表
 *
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
@Table(name = "subject")
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Subject implements Serializable {
    private static final long serialVersionUID = -7117853894768916495L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 课程时长
     */
    private Integer times;

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