<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <link ref="stylesheet" href="../../js/bootstrap.css">
</head>

<body>
<div class="container">
    <div>
        <i class="icon-table"></i> 学生信息管理
        <a href="${pageContext.request.contextPath}/StudentServlet?method=ToCreate">添加学生</a>
    </div>
    <div>
        <table style="border: 1px solid #ccc">
            <thead>
            <tr>
                <th nowrap>姓名</th>
                <th nowrap>年龄</th>
                <th nowrap>性别</th>
                <th nowrap>地址</th>
                <th nowrap>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="stus">
                <tr data-key="4">
                    <td>${stus.sname}</td>
                    <td>${stus.age}</td>
                    <td>${stus.gender}</td>
                    <td>${stus.address}</td>
                    <td>
                        <button onclick="del(this)" id="${stus.id}">删除</button>
                        <button onclick="examine(this)" id="${stus.id}">查看</button>
                        <button onclick="updateStudent(this)" id="${stus.id}">修改</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>

<script type="text/javascript" src="../../js/jquery-3.0.0.js"></script>
<script>
    function examine(obj) {
        var $PrimaryKey = $(obj).attr("id");
        location.href = 'StudentServlet?method=selectByPrimaryKey&type=1&PrimaryKey=' + $PrimaryKey;
    }

    function updateStudent(obj) {
        var $OneId = $(obj).attr("id");
        location.href = 'StudentServlet?method=selectByPrimaryKey&OneId=' + $OneId;
    }

    function del(obj) {
        var $delId = $(obj).attr("id");
        location.href = 'StudentServlet?method=deleteStudent&delId=' + $delId;
    }
</script>
</body>
</html>
