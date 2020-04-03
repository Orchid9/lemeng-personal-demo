package com.lemeng.personal.controller;

import com.lemeng.personal.dto.ScoreDto;
import com.lemeng.personal.model.StudentGrade;
import com.lemeng.personal.service.CourseService;
import com.nhsoft.provider.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Api("学校成绩查询")
@RestController
public class SchoolScoresController {

    @Autowired
    private CourseService courseService;

    /**
     * 教学处主任,教师，可以查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param academicYear 学年
     * @param subjectId    学科id
     * @return 学科平均成绩，最高分，最低分
     */
    @ApiOperation("教学处主任,教师，可以查询教师本人每学年，学科平均成绩，最高分，最低分")
    @GetMapping("nhsoft.demo.findScores")
    public Response findScores(@ApiParam("学年") String academicYear, @ApiParam("学科id") Integer subjectId) {
        ScoreDto scores = courseService.findScores(academicYear, subjectId);
        return Response.data(scores);
    }

    /**
     * 查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param teacherId    教师id
     * @param academicYear 学年
     * @return 学科平均成绩，最高分，最低分
     */
    @ApiOperation("查询教师本人每学年，学科平均成绩，最高分，最低分")
    @GetMapping("nhsoft.demo.findTeacherScores")
    public Response<ScoreDto> findTeacherScores(@ApiParam("教师id") String teacherId, @ApiParam("学年") String academicYear) {
        ScoreDto teacherScores = null;
        try {
            teacherScores = courseService.findTeacherScores(teacherId, academicYear);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return Response.data(teacherScores);
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
    @GetMapping("nhsoft.demo.findStudentScores")
    public Response<List<StudentGrade>> findStudentScores(@ApiParam("学生id") String student_id, @ApiParam("学年") String academic_year, @ApiParam("开始页") int pageNumber, @ApiParam("页面数量") int pageSize) {
        List<StudentGrade> studentScores = courseService.findStudentScores(student_id, academic_year, pageNumber, pageSize);
        return Response.data(studentScores);
    }
}
