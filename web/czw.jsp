<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/11/3
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<head>
    <title>czw</title>
</head>
<body>
<a href="historyServlet">查询历史</a>
<form action="Servlet" method="post"><input name="x" value="${param.x}">
    <select name="op">
    <option value="+"${param.op eq '+'?' selected="selected"':''}>+</option>
    <option value="-"${param.op eq '-'?' selected="selected"':''}>-</option>
    <option value="*"${param.op eq '*'?' selected="selected"':''}>*</option>
    <option value="/"${param.op eq '/'?' selected="selected"':''}>/</option>
    </select>
    <input name="y" value="${param.y}">
    <button type="submit">=</button>
    ${result}
</form>

</body>
</html>
