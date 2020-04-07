package com.lemeng.personal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 教师学科信息
 *
 * @Author 张九星
 * @create 2020/4/7 16:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherWithSubjectInfoDTO {

    private Integer id;

    /**
     * 教师id
     */
    private String teacherId;

    /**
     * 课程id
     */
    private Integer subjectId;

}
