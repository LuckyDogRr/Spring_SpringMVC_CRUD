package net.wanho.service;

import net.wanho.pojo.Student;

import java.util.List;

/**
 * Created by Administrator on 2019/4/10.
 */
public interface StudentServiceI {
    void addStudent(Student student);

    void deleteStudent(Integer id) ;

    void updateStudent(Student student) ;

    Student queryOneById(Integer id) ;

    List<Student> getAllStudents();
}
