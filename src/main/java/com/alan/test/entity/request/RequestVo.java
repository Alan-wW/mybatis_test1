package com.alan.test.entity.request;

import com.alan.test.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Alan_
 * @create 2021/9/30 8:10
 * @Description:
 */
@Data
@NoArgsConstructor
public class RequestVo implements Serializable {
    private Student student;
    private String courseName;
}
