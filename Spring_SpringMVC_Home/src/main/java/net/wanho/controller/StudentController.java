package net.wanho.controller;

import net.wanho.pojo.Student;
import net.wanho.service.StudentServiceI;
import net.wanho.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
public class StudentController {


    @Autowired
    private StudentServiceI studentServiceI;

    @RequestMapping("toIndex")
    public String toIndex() {
        return "index";
    }


    @RequestMapping("toCreate")
    public String toCreate() {
        return "create";
    }

    @RequestMapping("AllStudents")
    public String GetAllStudents(Map map) {
        List<Student> students = studentServiceI.getAllStudents();
        map.put("students", students);
        return "index";
    }

    @RequestMapping("delStudent")
    public String delStudent(@RequestParam("delId") Integer id) {
        studentServiceI.deleteStudent(id);
        return "redirect:/AllStudents";
    }

    @RequestMapping("SelectOne")
    public String SelectOne(@RequestParam("upId") Integer id, Map map) {
        Student UpStu = studentServiceI.queryOneById(id);
        map.put("UpStu", UpStu);
        return "update";
    }


    @RequestMapping("UpdateStudent")
    public String UpdateStudent(Student student,HttpServletRequest request) {
        student.setId(Integer.parseInt(request.getParameter("Student_id")));
        student.setSname(request.getParameter("sname"));
        student.setAge(Integer.parseInt(request.getParameter("age")));
        student.setGender(request.getParameter("gender"));
        student.setAddress(request.getParameter("address"));
        studentServiceI.updateStudent(student);
        return "redirect:/AllStudents";
    }

    @RequestMapping("AddStudent")
    public String AddStudent(Student student, HttpServletRequest request) {
        student.setSname(request.getParameter("sname"));
        student.setAge(Integer.parseInt(request.getParameter("age")));
        student.setGender(request.getParameter("gender"));
        student.setAddress(request.getParameter("address"));
        studentServiceI.addStudent(student);
        return "redirect:/AllStudents";
    }
}
