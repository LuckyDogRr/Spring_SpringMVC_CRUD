package net.wanho.service;

import net.wanho.pojo.Student;

import java.util.List;

/**
 * Created by rs on 2019/6/4.
 */
public interface StudentServiceI {
    void addStudent(Student student);

    void deleteStudent(Integer id) ;

    void updateStudent(Student student) ;

    Student queryOneById(Integer id) ;

    List<Student> getAllStudents();
}
