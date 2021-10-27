package com.alan.test.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2021-09-26 18:43:16
 */
@Data
@NoArgsConstructor
public class Student implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 学生名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别，0-女，1-男
     */
    private Integer sex;
    /**
     * 课程信息
     */
    private List<Subject> subjects;
}

