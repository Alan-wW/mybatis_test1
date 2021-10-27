package com.alan.test.service.impl;

import com.alan.test.entity.Student;
import com.alan.test.mapper.StudentDao;
import com.alan.test.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2021-09-26 18:43:16
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(Integer id) {
        return this.studentDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param student     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Student> queryByPage(Student student, PageRequest pageRequest) {
        long total = this.studentDao.count(student);
        return new PageImpl<>(this.studentDao.queryAllByLimit(student, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student insert(Student student) {
        this.studentDao.insert(student);
        return student;
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student update(Student student) {
        this.studentDao.update(student);
        return this.queryById(student.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String[] id) {
        List<Integer> arr = new ArrayList<>();
        for(int i = 0;i < id.length;i++){
            arr.add(Integer.parseInt(id[i]));
        }
        return this.studentDao.deleteById(arr) > 0;
    }

    @Override
    public List<Student> getList() {
        List<Student> list = studentDao.getList();
        return list;
    }

    @Override
    public List<Student> likeQuery(String name) {
        return this.studentDao.likeQuery(name);
    }

    @Override
    public Long totalCount() {

        return this.studentDao.count(null);
    }
}
