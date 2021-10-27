package com.alan.test.service;

import com.alan.test.entity.Student;
import com.alan.test.entity.Subject;

import java.util.List;

/**
 * @Author Alan_
 * @create 2021/10/7 8:49
 * @Description:
 */
public interface SubjectService {
    List<Subject> findAll();

    Subject selectOne(Integer id);

    Integer insert(Subject subject);

    Integer update(Subject subject);

    int delete(Integer id);

    List<Subject> findStudent();
}
