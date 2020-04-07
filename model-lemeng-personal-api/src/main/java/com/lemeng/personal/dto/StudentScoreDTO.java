package com.lemeng.personal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
@ApiModel("学生成绩")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentScoreDTO {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("学生id")
    private String studentId;

    @ApiModelProperty("老师id")
    private String teacherId;

    @ApiModelProperty("课程id")
    private Integer subjectId;

    @ApiModelProperty("学年")
    private String academicYear;

    @ApiModelProperty("分数")
    private Integer score;

    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    @ApiModelProperty("更新时间")
    private Date gmtModified;
}
