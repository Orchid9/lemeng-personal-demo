package com.lemeng.personal.dto;

import com.google.gson.Gson;

import java.util.Date;

/**
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
class StudentGradeDtoTest {

    public static void main(String[] args) {
        StudentScoreDTO studentScoreDto = new StudentScoreDTO(4, "1", "2", 1, "2011", 80, new Date(), new Date());
        System.out.println(new Gson().toJson(studentScoreDto));
        System.out.println(new Date().getTime());
        System.out.println(new Date().getTime());
    }

}