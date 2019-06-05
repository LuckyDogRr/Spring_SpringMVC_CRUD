<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <script type="text/javascript" src="../../js/jquery-3.0.0.js"></script>
    <link rel="stylesheet" href="../../js/bootstrap.css">
    <script type="text/javascript" src="../../js/bootstrap-3.3.4.js"></script>
</head>

<body>
<div class="container">
    <div>
        <i class="icon-table"></i> 学生信息管理
        <a class=" btn-xs bg-primary"
           href="${pageContext.request.contextPath}/toCreate">添加</a>
    </div>
    <div class="table-responsive">
        <table class="table  table-bordered table-hover table-condensed ">
            <tr>
                <th nowrap>姓名</th>
                <th nowrap>年龄</th>
                <th nowrap>性别</th>
                <th nowrap>地址</th>
                <th nowrap>操作</th>
            </tr>
            <tbody class="active">
            <c:forEach items="${students}" var="stus">
                <tr>
                    <td>${stus.sname}</td>
                    <td>${stus.age}</td>
                    <td>${stus.gender}</td>
                    <td>${stus.address}</td>
                    <td>
                        <a class="btn-xs bg-danger" onclick="del(this)" id="${stus.id}">删除</a>
                        <a class=" btn-xs bg-info" onclick="updateStudent(this)" id="${stus.id}">修改</a>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>


<script>

    function updateStudent(obj) {
        var $OneId = $(obj).attr("id");
        location.href = "SelectOne?upId=" + $OneId;
    }

    function del(obj) {
        var $delId = $(obj).attr("id");
        location.href = "delStudent?delId= " + $delId;
    }

</script>
</body>
</html>
