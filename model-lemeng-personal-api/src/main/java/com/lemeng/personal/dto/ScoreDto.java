package com.lemeng.personal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("分数实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDto {

    @ApiModelProperty("最高分")
    private Integer maxScore;

    @ApiModelProperty("最低分")
    private Integer minScore;

    @ApiModelProperty("平均分")
    private Double averageScore;
}
