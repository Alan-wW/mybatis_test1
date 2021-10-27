package com.alan.test.service.impl;

import com.alan.test.entity.Student;
import com.alan.test.entity.Subject;
import com.alan.test.mapper.SubjectDao;
import com.alan.test.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Alan_
 * @create 2021/10/7 8:49
 * @Description:
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public List<Subject> findAll() {
        return subjectDao.findAll();
    }

    @Override
    public Subject selectOne(Integer id) {
        return subjectDao.selectOne(id);
    }

    @Override
    public Integer insert(Subject subject) {

        return subjectDao.insert(subject);
    }

    @Override
    public Integer update(Subject subject) {
        return subjectDao.update(subject);
    }

    @Override
    public int delete(Integer id) {
        return subjectDao.delete(id);
    }

    @Override
    public List<Subject> findStudent() {

        return subjectDao.findStudent();
    }
}
