<%--
  Created by IntelliJ IDEA.
  User: chenm
  Date: 2016/5/8
  Time: 1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--详细JSP教程（包括模板标签）：http://www.runoob.com/jsp/jsp-jstl.html--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>Show</title>
    <link rel="stylesheet" href="assets/demo.css">

    <!-- base需要放到head中 -->
    <base href=" <%=basePath%>">
</head>
<body>
    <h1>${helloPara}</h1>
    <h1>${i}</h1>
    <h1>${bool}</h1>

    <c:forEach items="${list}" var="l">
        <h1>${l}</h1>
    </c:forEach>

    <form action="/form" name="form-test-1" method="post">
        <input type="text" name="username">
        <input type="submit" name="sub-test-1">
    </form>

    <form action="/form" name="form-test-2" method="post">
        <input type="text" name="username2">
        <input type="submit" name="sub-test-2">
    </form>

    <a href="/repo">fffff</a>
</body>
</html>
