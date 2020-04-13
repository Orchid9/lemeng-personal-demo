package com.lemeng.personal.controller;

import com.lemeng.personal.dto.ScoreDTO;
import com.lemeng.personal.model.ScoreModel;
import com.lemeng.personal.model.StudentScore;
import com.lemeng.personal.service.StudentScoreService;
import com.nhsoft.provider.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
@Api("学校成绩查询")
@RestController
public class StudentScoreController {

    @Autowired
    private StudentScoreService studentScoreService;

    /**
     * 教学处主任,教师，可以查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param academic_year 学年
     * @param subject_id    学科id
     * @return 学科平均成绩，最高分，最低分
     */
    @ApiOperation("教学处主任,教师，可以查询教师本人每学年，学科平均成绩，最高分，最低分")
    @GetMapping("nhsoft.demo.score.read")
    public Response readScore(@ApiParam("学年") String academic_year, @ApiParam("学科id") Integer subject_id) {
        ScoreDTO score = new ScoreDTO();
        ScoreModel scoreModel = studentScoreService.readScore(academic_year, subject_id);
        BeanUtils.copyProperties(scoreModel, score);
        return Response.data(score);
    }

    /**
     * 查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param teacher_id    教师id
     * @param academic_year 学年
     * @param subject_id    学科id
     * @return 学年平均成绩
     */
    @ApiOperation("查询教师本人每学年，学科平均成绩，最高分，最低分")
    @GetMapping("nhsoft.demo.teacher.score.read")
    public Response<ScoreDTO> findTeacherScores(@ApiParam("教师id") String teacher_id, @ApiParam("学年") String academic_year, @ApiParam("学科id") Integer subject_id) {
        ScoreDTO scoreDTO = new ScoreDTO();
        ScoreModel scoreModel = studentScoreService.readTeacherScore(teacher_id, academic_year, subject_id);
        BeanUtils.copyProperties(scoreModel, scoreDTO);
        return Response.data(scoreDTO);
    }

    /**
     * 学生查询本人每学年各学科成绩
     *
     * @param student_id    学生id
     * @param academic_year 学年
     * @param page_number   开始页：0为初始页面
     * @param page_size     页面数量
     * @return 学生各学科成绩
     */
    @ApiOperation("学生查询本人每学年各学科成绩")
    @GetMapping("nhsoft.demo.student.scores.find")
    public Response<List<StudentScore>> findStudentScores(@ApiParam("学生id") String student_id, @ApiParam("学年") String academic_year, @ApiParam("开始页") int page_number, @ApiParam("页面数量") int page_size) {
        List<StudentScore> studentScores = studentScoreService.findStudentScores(student_id, academic_year, page_number, page_size);
        return Response.data(studentScores);
    }
}
