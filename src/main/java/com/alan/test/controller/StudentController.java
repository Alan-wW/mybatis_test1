package com.alan.test.controller;

import com.alan.test.entity.resp.Result;
import com.alan.test.entity.Student;
import com.alan.test.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2021-09-26 18:43:15
 */
@RestController
@RequestMapping("student")
//@CrossOrigin
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 查询所有数据
     */
    @GetMapping
    public Result getList(){
        List<Student> data = this.studentService.getList();

        Result result = Result.ok().data("resultList", data);
        return result;
    }
    /**
     * 分页查询
     *
     * @param student 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/queryPage")
    public ResponseEntity<Page<Student>> queryByPage(Student student, PageRequest pageRequest) {
        return ResponseEntity.ok(this.studentService.queryByPage(student, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Student> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.studentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param student 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Student> add(Student student) {
        return ResponseEntity.ok(this.studentService.insert(student));
    }

    /**
     * 编辑数据
     *
     * @param student 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Student> edit(Student student) {
        return ResponseEntity.ok(this.studentService.update(student));
    }

    /**
     * 删除数据
     *
     * @param ids 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result deleteById(String id) {
        String[] ids = id.split(",");
        this.studentService.deleteById(ids);
        return Result.ok();
    }

    /**
     * 根据姓名进行模糊查询
     */
    @GetMapping("/queryName")
    public Result likeQuery(String name){
        List<Student> students = this.studentService.likeQuery(name);
        return Result.ok().data("students",students);
    }

    /**
     * 查询学生表数据总条数
     * @return
     */
    @GetMapping("/count")
    public Result totalCount(){
        Long count = this.studentService.totalCount();
        return Result.ok().data("count",count);
    }
}

