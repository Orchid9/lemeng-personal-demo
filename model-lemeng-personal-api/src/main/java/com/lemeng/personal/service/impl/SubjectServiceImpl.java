package com.lemeng.personal.service.impl;

import com.lemeng.personal.model.Subject;
import com.lemeng.personal.repository.SubjectRepository;
import com.lemeng.personal.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Author 张九星
 * @create 2020/4/7 16:35
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject readSubject(Integer subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubjectById(Integer subjectId) {
        subjectRepository.deleteById(subjectId);
    }
}
