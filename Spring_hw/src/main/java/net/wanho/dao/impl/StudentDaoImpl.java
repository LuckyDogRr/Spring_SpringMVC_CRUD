package net.wanho.dao.impl;

import net.wanho.dao.StudentDaoI;
import net.wanho.pojo.Student;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDaoI {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    RowMapper<Student> rowMapper =new BeanPropertyRowMapper<Student>(Student.class);
    @Before
    public  void  before(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        jdbcTemplate=ctx.getBean(JdbcTemplate.class);
    }


    @Override
    public void addStudent(Student student)  {
        jdbcTemplate.update("INSERT  INTO  student VALUES (NULL,?,?,?,?)",student.getSname()
        ,student.getAge(),student.getGender(),student.getAddress());
        System.out.println("添加成功");
    }

    @Override
    public void deleteStudent(Integer id){
        jdbcTemplate.update("DELETE  FROM student WHERE  id=?",id);
        System.out.println("删除成功");
    }

    @Override
    public void updateStudent(Student student) {
        jdbcTemplate.update("UPDATE student SET  sname=?,age=?,gender=?,address=? where id=?",student.getSname()
        ,student.getAge(),student.getGender(),student.getAddress(),student.getId());
        System.out.println("修改成功");
    }

    @Override
    public Student queryOneById(Integer id)  {
        Student student = jdbcTemplate.queryForObject("select * from student where id=?",rowMapper,id);
        System.out.println("查询单个成功");
        return student;

    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = jdbcTemplate.query("select * from student", rowMapper);
        System.out.println("查询所有成功");
        return students;
    }
}
