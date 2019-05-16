<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.neuedu.model.po.Emp" %>
<%--
  Created by IntelliJ IDEA.
  User: m1832
  Date: 2019/5/16
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--get from info from request--%>
<%--el expression lauguage, el expression is to get data from request, session, application--%>
<%= request.getAttribute("msg")%>
<p>msg:${msg}</p>
<p>requestScope.msg:${requestScope.msg}</p>
<p>list:${list}</p>



<table>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.empno}</td>
            <td>${item.ename}</td>
            <td>${item.job}</td>
            <td>${item.hiredatestr}</td>
        </tr>
    </c:forEach>
</table>

<%--jstl tagelib is uesd together with el--%>
<%
    List<Emp> list = (List<Emp>) request.getAttribute("list");
    for (Emp e : list) {

%>
<%=e.getEname()%>,<%=e.getHiredatestr()%>
<%
    }
%>
</body>
</html>
