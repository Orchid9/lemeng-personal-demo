package com.lemeng.personal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 张九星
 * @create 2020/4/7 17:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {

    /**
     * 学号
     */
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
}
