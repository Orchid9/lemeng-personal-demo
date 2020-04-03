package com.lemeng.personal.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 课程表
 */
@Table(name = "subject")
@Entity
@Data
public class Subject implements Serializable {
    private static final long serialVersionUID = -7117853894768916495L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    /**
     * 课程名称
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 课程时长
     */
    @Column(name = "times", nullable = false)
    private Integer times;

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