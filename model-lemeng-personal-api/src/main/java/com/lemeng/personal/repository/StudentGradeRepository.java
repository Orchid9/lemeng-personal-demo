package com.lemeng.personal.repository;

import com.lemeng.personal.dto.ScoreDto;
import com.lemeng.personal.model.StudentGrade;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface StudentGradeRepository extends JpaRepository<StudentGrade, Integer>, JpaSpecificationExecutor<StudentGrade> {

    @Query(value = "SELECT new com.lemeng.personal.dto.ScoreDto(MAX(sg.score), MIN(sg.score) ,AVG(sg.score))" +
            "from StudentGrade sg " +
            "WHERE sg.academicYear = :academicYear AND sg.subjectId = :subjectId")
    ScoreDto findScores(@Param("academicYear") String academic_year, @Param("subjectId") Integer subject_id);

    @Query(nativeQuery = true, value =
            "SELECT MAX(scores.avg) maxScore ,MIN(scores.avg) minScore, AVG(scores.avg) averageScore " +
                    "FROM (" +
                    "SELECT AVG(sg.score) avg " +
                    "FROM student_grade sg " +
                    "WHERE sg.teacher_id = :teacherId AND sg.academic_year = :academicYear " +
                    "GROUP BY sg.subject_id) scores")
    Map<String, Object> findTeacherScores(@Param("teacherId") String teacher_id, @Param("academicYear") String academic_year);

    List<StudentGrade> findStudentGradesByStudentIdAndAcademicYear(String student_id, String academic_year, Pageable pageRequest);
}