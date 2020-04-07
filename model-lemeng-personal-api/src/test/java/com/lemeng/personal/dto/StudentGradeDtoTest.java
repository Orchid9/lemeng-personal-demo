package com.lemeng.personal.dto;

import com.google.gson.Gson;

import java.util.Date;


class StudentGradeDtoTest {

    public static void main(String[] args) {
        StudentGradeDto studentGradeDto = new StudentGradeDto(4, "1", "2", 1, "2011", 80, new Date(), new Date());
        System.out.println(new Gson().toJson(studentGradeDto));
        System.out.println(new Date().getTime());
        System.out.println(new Date().getTime());
    }

}