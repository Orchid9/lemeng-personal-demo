package com.lemeng.personal.service;

import com.lemeng.personal.model.Subject;
import org.springframework.stereotype.Repository;

/**
 * @Author 张九星
 * @create 2020/4/7 16:35
 */
@Repository
public interface SubjectService {
    /**
     * 查询学科详细信息
     *
     * @param subjectId 学科id
     * @return 学科详细信息
     */
    Subject readSubject(Integer subjectId);

    /**
     * 保存更新学科详细信息
     *
     * @param subject 学科信息
     * @return 保存更新的对象信息
     */
    Subject saveSubject(Subject subject);

    /**
     * 删除学科详细信息
     *
     * @param subjectId 学科信息
     * @return 删除结果
     */
    void deleteSubjectById(Integer subjectId);
}
