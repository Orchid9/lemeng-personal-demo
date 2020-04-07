package com.lemeng.personal.controller;

import com.lemeng.personal.dto.ScoreDto;
import com.lemeng.personal.dto.StudentGradeDto;
import com.lemeng.personal.model.StudentGrade;
import com.lemeng.personal.service.StudentGradeService;
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
public class StudentGradeController {

    @Autowired
    private StudentGradeService studentGradeService;

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
        ScoreDto scores = studentGradeService.findScores(academicYear, subjectId);
        return Response.data(scores);
    }

    /**
     * 查询教师本人每学年，学科平均成绩，最高分，最低分
     *
     * @param teacherId    教师id
     * @param academicYear 学年
     * @param subjectId    学科id
     * @return 学年平均成绩
     */
    @ApiOperation("查询教师本人每学年，学科平均成绩，最高分，最低分")
    @GetMapping("nhsoft.demo.findTeacherScores")
    public Response<ScoreDto> findTeacherScores(@ApiParam("教师id") String teacherId, @ApiParam("学年") String academicYear, @ApiParam("学科id") Integer subjectId) {
        ScoreDto teacherScores = studentGradeService.findTeacherScores(teacherId, academicYear, subjectId);
        return Response.data(teacherScores);
    }

    /**
     * 学生查询本人每学年各学科成绩
     *
     * @param studentId    学生id
     * @param academicYear 学年
     * @param pageNumber   开始页：0为初始页面
     * @param pageSize     页面数量
     * @return 学生各学科成绩
     */
    @ApiOperation("学生查询本人每学年各学科成绩")
    @GetMapping("nhsoft.demo.findStudentScores")
    public Response<List<StudentGrade>> findStudentScores(@ApiParam("学生id") String studentId, @ApiParam("学年") String academicYear, @ApiParam("开始页") int pageNumber, @ApiParam("页面数量") int pageSize) {
        List<StudentGrade> studentScores = studentGradeService.findStudentScores(studentId, academicYear, pageNumber, pageSize);
        return Response.data(studentScores);
    }

    /**
     * 保存修改学生成绩
     *
     * @param studentGradeDto 学生成绩json对象
     * @return 保存的学生信息
     */
    @ApiOperation("保存修改学生成绩")
    @PostMapping("nhsoft.demo.saveStudentGrade")
    public Response<StudentGrade> saveStudentGrade(@ApiParam("学生成绩json对象") @RequestBody StudentGradeDto studentGradeDto) {
        StudentGrade studentGrade = new StudentGrade();
        BeanUtils.copyProperties(studentGradeDto, studentGrade);
        return Response.data(studentGradeService.saveStudentGrade(studentGrade));
    }

    /**
     * 删除学生成绩
     *
     * @param id 学生成绩id主键
     * @return 处理结果
     */
    @ApiOperation("删除学生成绩")
    @DeleteMapping("nhsoft.demo.delStudentGrade")
    public Response delStudentGrade(@ApiParam("学生成绩id主键") Integer id) {
        studentGradeService.delStudentGradeById(id);
        return Response.empty();
    }
}
