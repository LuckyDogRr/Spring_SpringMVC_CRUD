package net.wanho;

import net.wanho.pojo.Student;
import net.wanho.service.StudentServiceI;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Administrator on 2019/4/10.
 */
public class StudentTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private ApplicationContext context;
    private StudentServiceI studentServiceI;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        jdbcTemplate = context.getBean(JdbcTemplate.class);
    }

    @Test
    public  void  add()  {

        StudentServiceI studentServiceI=context.getBean(StudentServiceI.class);
        studentServiceI.addStudent(new Student(4,"影子",12,"女","上海"));
    }

    @Test
    public  void  del()  {
            StudentServiceI studentServiceI=context.getBean(StudentServiceI.class);
            studentServiceI.deleteStudent(9);
        }

    @Test
    public  void  up()  {
        StudentServiceI studentServiceI=context.getBean(StudentServiceI.class);
        studentServiceI.updateStudent(new Student(18,"db",20,"男","宿迁"));
    }

    @Test
    public  void  queryA()  {
        StudentServiceI studentServiceI=context.getBean(StudentServiceI.class);
       List<Student> students=studentServiceI.getAllStudents();
        System.out.println(students);
    }

    @Test
    public  void  queryO()  {
        StudentServiceI studentServiceI=context.getBean(StudentServiceI.class);
        Student student=studentServiceI.queryOneById(2);
        System.out.println(student);
    }
}
