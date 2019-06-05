package net.wanho.service.impl;

import net.wanho.dao.StudentDaoI;
import net.wanho.pojo.Student;
import net.wanho.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rs on 2019/6/4.
 */
@Service
public class StudentServiceImpl implements StudentServiceI {

    @Autowired(required = false)
    private StudentDaoI studentDaoI;

    @Override
    public void addStudent(Student student) {
        studentDaoI.addStudent(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentDaoI.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDaoI.updateStudent(student);
    }

    @Override
    public Student queryOneById(Integer id) {
        return studentDaoI.queryOneById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDaoI.getAllStudents();
    }
}
