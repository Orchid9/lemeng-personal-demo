package com.lemeng.personal.repository;

import com.lemeng.personal.dto.ScoreDto;
import com.lemeng.personal.model.StudentGrade;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentGradeRepository extends JpaRepository<StudentGrade, Integer>, JpaSpecificationExecutor<ScoreDto> {

    @Query(value = "SELECT new com.lemeng.personal.dto.ScoreDto(MAX(sg.score), MIN(sg.score) ,AVG(sg.score))" +
            "from StudentGrade sg " +
            "WHERE sg.academicYear = :academicYear AND sg.subjectId = :subjectId")
    ScoreDto findScores(@Param("academicYear") String academicYear, @Param("subjectId") Integer subjectId);

    @Query(value = "SELECT new com.lemeng.personal.dto.ScoreDto(MAX(sg.score), MIN(sg.score) ,AVG(sg.score))" +
            "from StudentGrade sg " +
            "WHERE sg.teacherId = :teacherId AND sg.academicYear = :academicYear AND sg.subjectId = :subjectId")
    ScoreDto findTeacherScores(@Param("teacherId") String teacherId, @Param("academicYear") String academicYear, @Param("subjectId") Integer subjectId);

    List<StudentGrade> findStudentGradesByStudentIdAndAcademicYear(String student_id, String academic_year, Pageable pageRequest);
}