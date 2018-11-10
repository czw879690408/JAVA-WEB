<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/11/10
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>

<!DOCTYPE html>
<head>
    <title>历史查询记录</title>
    <style>
        table{
        text-align: center;
        border-collapse:collapse;
    }</style>

</head>
<body><center>
<div>
    <div><h2>历史纪录</h2></div>
    <div></div>
</div>
<table border="1">
    <tr>
        <th>X</th>
        <th> </th>
        <th>Y</th>
        <th>=</th>
        <th>result</th>
    </tr>

<% for ( controller.calcEntity calcEntity: (List<controller.calcEntity>)request.getAttribute("en")){%>
    <tr>
        <th><%=calcEntity.getX()%></th>
        <th><%=calcEntity.getOp()%></th>
        <th><%=calcEntity.getY()%></th>
        <th>=</th>
        <th><%=calcEntity.getResult()%></th>
    </tr>
<%}%>
</table>
</center>
</body>
</!DOCTYPE html>
