package com.alan.test.controller;

import com.alan.test.entity.Student;
import com.alan.test.entity.Subject;
import com.alan.test.entity.resp.Result;
import com.alan.test.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

/**
 * @Author Alan_
 * @create 2021/10/7 8:48
 * @Description:
 */
@RestController
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * 查询所有课程信息
     */
    @GetMapping
    public Result getAll(){
        List<Subject> all = this.subjectService.findAll();
        return Result.ok().data("subjectList",all);
    }

    /**
     * 根据课程ID查询
     */
    @GetMapping("{id}")
    public Result getSubjectById(@PathVariable("id") Integer id){
        Subject subject = this.subjectService.selectOne(id);
        return Result.ok().data("subject",subject);
    }

    /**
     * 添加课程信息
     */
    @PostMapping()
    public Result insertSubject(Subject subject){
        Integer code = this.subjectService.insert(subject);
        if(code > 0){
            return Result.ok();
        }else{
            return Result.error();
        }
    }

    /**
     * 更新课程信息
     */
    @PutMapping()
    public Result updateSubject(Subject subject){
        if(subject == null){
            return Result.error().message("更新信息不能为空");
        }
        if(subject.getCourseName() == null || subject.getCourseName().equals("")){
            return Result.error().message("课程名不能为空");
        }
        if(subject.getIntroduce() == null || subject.getIntroduce().equals("")){
            return Result.error().message("课程介绍不能为空");
        }
        Integer code = this.subjectService.update(subject);
        if(code > 0){
            return Result.ok();
        }else{
            return Result.error();
        }
    }

    /**
     * 根据课程ID删除课程信息
     * @param id
     * @return
     */
    @DeleteMapping()
    public Result deleteSubject(Integer id){
        int code = this.subjectService.delete(id);
        return code > 0 ? Result.ok() : Result.error();
    }

    /**
     * 查询选择某门课程得学生信息
     * @return
     */
    @GetMapping("/findStudent")
    public Result findStudent(){
        List<Subject> list = this.subjectService.findStudent();
        return Result.ok().data("StudentList",list);
    }
}
