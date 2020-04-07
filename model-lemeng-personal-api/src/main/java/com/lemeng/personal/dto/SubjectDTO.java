package com.lemeng.personal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 课程表
 *
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO implements Serializable {
    private static final long serialVersionUID = -7117853894768916495L;

    private Integer id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 课程时长
     */
    private Integer times;
}