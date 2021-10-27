package com.alan.test.mapper;

import com.alan.test.entity.Student;
import com.alan.test.entity.Subject;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Author Alan_
 * @create 2021/10/7 8:50
 * @Description:
 */
@Mapper
public interface SubjectDao {
    @Select("select * from subject")
    @Results(id = "subjectMap",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "course_name",property = "courseName"),
            @Result(column = "introduce",property = "introduce")
    })
    List<Subject> findAll();

    @Select("select * from subject where id = #{id}")
    @ResultMap("subjectMap")
    Subject selectOne(Integer id);

    @Insert("insert into subject(course_name,introduce) values(#{courseName},#{introduce})")
    Integer insert(Subject subject);


    @Update("update subject set course_Name = #{courseName},introduce = #{introduce} where id = #{id}")
    Integer update(Subject subject);

    @Delete("delete from subject where id = #{id}")
    int delete(Integer id);

    @Select("select * from subject")
    @Results(value = {
            @Result(column = "id",property = "id"),
            @Result(column = "course_name",property = "courseName"),
            @Result(column = "introduce",property = "introduce"),
            @Result(
                    property = "studentsList",
                    column = "id",
                    many = @Many(select = "com.alan.test.mapper.StudentDao.findStudents",fetchType = FetchType.LAZY))
    })
    List<Subject> findStudent();
}
