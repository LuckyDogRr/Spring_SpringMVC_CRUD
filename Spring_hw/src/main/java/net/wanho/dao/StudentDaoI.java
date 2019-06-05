package net.wanho.dao;

import net.wanho.pojo.Student;

import java.util.List;

public interface StudentDaoI {

    void addStudent(Student student) ;

    void deleteStudent(Integer id) ;

    void updateStudent(Student student) ;

    Student queryOneById(Integer id) ;

    List<Student> getAllStudents();
}
