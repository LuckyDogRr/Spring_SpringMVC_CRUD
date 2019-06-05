<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <script type="text/javascript" src="../../js/jquery-3.0.0.js"></script>
    <link rel="stylesheet" href="../../js/bootstrap.css">
    <script type="text/javascript" src="../../js/bootstrap-3.3.4.js"></script>
</head>

<body class="navbar-top">
<div class="modal-shiftfix">
    <div class="container-fluid main-content">
        <div class="widget-container fluid-height clearfix mwi1200">
            <div class="heading clearfix">
                <i class="icon-reorder"></i> 查看学生
                <i class="icon-reply pull-right" onclick="history.go(-1);"></i>
            </div>
            <div class="widget-content padded clearfix">
                <table class="table detail-view">
                    <tbody>
                    <tr>
                        <th>姓名</th>
                        <td>${AStu.sname}</td>
                    </tr>
                    <tr>
                        <th>年龄</th>
                        <td>${AStu.age}</td>
                    </tr>
                    <tr>
                        <th>性别</th>
                        <td>${AStu.gender}</td>
                    </tr>
                    <tr>
                        <th>地址</th>
                        <td>${AStu.address}</td>
                    </tr>
                    </tbody>
                </table>
                <div style="margin:0 auto; text-align:center;">
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
