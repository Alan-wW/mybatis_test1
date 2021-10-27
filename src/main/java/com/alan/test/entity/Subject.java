package com.alan.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Struct;
import java.util.List;

/**
 * @Author Alan_
 * @create 2021/9/26 20:03
 * @Description: 课程实体类
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(value = { "handler" })
public class Subject implements Serializable {
    /**
     * 课程Id
     */
    private Integer id;
    /**
     * 课程名
     */
    private String courseName;
    /**
     * 课程简介
     */
    private String introduce;

    private List<Student> studentsList;
}
