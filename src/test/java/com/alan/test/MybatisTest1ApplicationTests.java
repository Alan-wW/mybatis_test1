package com.alan.test;

import com.alan.test.entity.Student;
import com.alan.test.entity.Subject;
import com.alan.test.mapper.StudentDao;
import com.alan.test.mapper.SubjectDao;
import com.alan.test.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MybatisTest1ApplicationTests {

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private StudentDao studentDao;

    @Test
    void contextLoads() {
        List<Subject> student = subjectDao.findStudent();
        System.out.println(student.toString());
    }

    @Test
    void test2() {
        Subject subject = subjectDao.selectOne(2);
        System.out.println(subject);
    }

    @Test
    void test3() {
        //List<Subject> all = subjectDao.findAll();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
    }
}
