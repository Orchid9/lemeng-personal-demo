package com.lemeng.personal.controller;

import com.lemeng.personal.model.StudentGrade;
import com.lemeng.personal.service.CourseService;
import com.nhsoft.provider.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api("学校成绩查询")
@RestController
public class SchoolScoresResource {

    @Autowired
    private CourseService courseService;

    /**
     * 教学处主任,教师，可以查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param academic_year 学年
     * @param subject_id    学科id
     * @return 学科平均成绩，最高分，最低分
     */
    @ApiOperation("教学处主任,教师，可以查询教师本人每学年，学科平均成绩，最高分，最低分")
    @GetMapping("/queryMaxAndMinAndAveScoresByAcaYearAndSubId")
    public Response queryScores(@ApiParam("学年") String academic_year, @ApiParam("学科id") Integer subject_id) {
        Response response = Response.empty();
        Map<String, Object> byAcaYearAndSubId = courseService.getMaxAndMinAndAveScoresByAcaYearAndSubId(academic_year, subject_id);
        response.setCode(0);
        response.setMsg("成功");
        response.setResult(byAcaYearAndSubId);
        return response;
    }

    /**
     * 查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param teacher_id    教师id
     * @param academic_year 学年
     * @return 学科平均成绩，最高分，最低分
     */
    @ApiOperation("查询教师本人每学年，学科平均成绩，最高分，最低分")
    @GetMapping("/queryMaxAndMinAndAveByAcaYearAndTeaId")
    public Response queryMaxAndMinAndAveByAcaYearAndTeaId(@ApiParam("教师id") String teacher_id, @ApiParam("学年") String academic_year) {
        Response response = Response.empty();
        Map<String, Object> maxAndMinAndAverageMap = courseService.getMaxAndMinAndAveByAcaYearAndTeaId(teacher_id, academic_year);
        response.setCode(0);
        response.setMsg("成功");
        response.setResult(maxAndMinAndAverageMap);
        return response;
    }

    /**
     * 学生查询本人每学年各学科成绩
     *
     * @param student_id    学生id
     * @param academic_year 学年
     * @param pageNumber    开始页：0为初始页面
     * @param pageSize      页面数量
     * @return 学生各学科成绩
     */
    @ApiOperation("学生查询本人每学年各学科成绩")
    @GetMapping("/queryStudentQueryScores")
    public Response studentQueryScores(@ApiParam("学生id") String student_id, @ApiParam("学年") String academic_year, @ApiParam("开始页") int pageNumber, @ApiParam("页面数量") int pageSize) {
        Response response = Response.empty();
        List<StudentGrade> studentGrade = courseService.getStudentQueryScores(student_id, academic_year, pageNumber, pageSize);
        response.setCode(0);
        response.setMsg("成功");
        response.setResult(studentGrade);
        return response;
    }
}
