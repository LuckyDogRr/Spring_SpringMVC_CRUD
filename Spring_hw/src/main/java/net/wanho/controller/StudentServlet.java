package net.wanho.controller;


import net.wanho.pojo.Student;
import net.wanho.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    @Autowired
    private StudentServiceI studentServiceI;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String methodName = request.getParameter("method");
        try {
            Method method = getClass().getDeclaredMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void init() throws ServletException {
//        在web容器中获取IOC容器
        ServletContext servletContext = getServletContext();
//        ioc容器
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        studentServiceI = ctx.getBean(StudentServiceI.class);

    }


    //查询列表数据
//查看所有信息
    protected void queryAllStudent(HttpServletRequest request, HttpServletResponse response) {

        try {
            List<Student> students = studentServiceI.getAllStudents();
            request.setAttribute("students", students);
            request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //查看单个信息
    protected void selectByPrimaryKey(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String id = request.getParameter("type");
            if (!"1".equals(id) && id != "1") {
                Integer OneId = Integer.parseInt(request.getParameter("OneId"));
                Student UpStu = studentServiceI.queryOneById(OneId);
                request.setAttribute("UpStu", UpStu);
                request.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(request,
                        response);
                return;
            } else {
                Integer PrimaryKey = Integer.parseInt(request.getParameter("PrimaryKey"));
                Student AStu = studentServiceI.queryOneById(PrimaryKey);
                request.setAttribute("AStu", AStu);
                request.getRequestDispatcher("/WEB-INF/jsp/view.jsp").forward(request,
                        response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //修改
    protected void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Student student = new Student();
        try {
            String sname = request.getParameter("sname");
            String age = request.getParameter("age");
            String gender = request.getParameter("Student_gender");
            String address = request.getParameter("address");
            String id = request.getParameter("Student_id");
            student.setSname(sname);
            student.setAge(Integer.parseInt(age));
            student.setGender(gender);
            student.setAddress(address);
            student.setId(Integer.parseInt(id));

            studentServiceI.updateStudent(student);
            response.sendRedirect(request.getContextPath() + "/StudentServlet?method=queryAllStudent");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除
    protected void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String delId = request.getParameter("delId");
            if (delId != null && !delId.equals("")) {
                int id = Integer.valueOf(delId);
                studentServiceI.deleteStudent(id);
            }
            response.sendRedirect(request.getContextPath() + "/StudentServlet?method=queryAllStudent");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 添加学生
    protected void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Student student = new Student();
        try {
            String sname = request.getParameter("sname");
            String age = request.getParameter("age");
            String gender = request.getParameter("gender");
            String address = request.getParameter("address");

            student.setAge(Integer.parseInt(age));
            student.setSname(sname);
            student.setGender(gender);
            student.setAddress(address);

            studentServiceI.addStudent(student);
            response.sendRedirect(request.getContextPath() + "/StudentServlet?method=queryAllStudent");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void ToCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("/WEB-INF/jsp/create.jsp").forward(request, response);
    }

}
