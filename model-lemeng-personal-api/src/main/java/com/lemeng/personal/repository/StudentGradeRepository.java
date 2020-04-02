package com.lemeng.personal.repository;

import com.lemeng.personal.model.StudentGrade;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface StudentGradeRepository extends JpaRepository<StudentGrade, Integer>, JpaSpecificationExecutor<StudentGrade> {

    @Query(value =
            "SELECT MAX(sg.score) as  max_score, MIN(sg.score) as min_score,AVG(sg.score) as average_score " +
                    "from StudentGrade sg " +
                    "WHERE sg.academicYear = :academicYear AND sg.subjectId = :subjectId")
    Map<String, Object> getMaxAndMinAndAveScoresByAcaYearAndSubId(@Param("academicYear") String academic_year, @Param("subjectId") Integer subject_id);

    @Query(nativeQuery = true, value =
            "SELECT MAX(scores.avg) max_score ,MIN(scores.avg) min_score, AVG(scores.avg) average_score " +
                    "FROM (" +
                    "SELECT AVG(sg.score) avg " +
                    "FROM student_grade sg " +
                    "WHERE sg.teacher_id = :teacherId AND sg.academic_year = :academicYear " +
                    "GROUP BY sg.subject_id) scores")
    Map<String, Object> getMaxAndMinAndAveByAcaYearAndTeaId(@Param("teacherId") String teacher_id, @Param("academicYear") String academic_year);

    List<StudentGrade> findStudentGradeByStudentIdAndAcademicYear(String student_id, String academic_year, Pageable pageRequest);
}