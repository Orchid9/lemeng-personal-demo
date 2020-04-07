package com.lemeng.personal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 张九星
 * @create 2020/4/7 15:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreModel {
    /**
     * 最高分
     */
    private Integer maxScore;

    /**
     * 最低分
     */
    private Integer minScore;

    /**
     * 平均分
     */
    private Double averageScore;
}
