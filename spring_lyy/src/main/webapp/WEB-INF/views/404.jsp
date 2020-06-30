<%--
  Created by IntelliJ IDEA.
  User: Fuck You
  Date: 2019/8/8
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404</title>
</head>
<body>
<h3>哎呦，系统失联了...</h3>
<div id="exception" style="display: none">

        <%
            Exception ex = (Exception) request.getAttribute("exception");
        %>
    <H2>
        Exception:
        <%=ex.getMessage()%></H2>
    <P />
        <%
            ex.printStackTrace();
        %>
</body>
</html>
