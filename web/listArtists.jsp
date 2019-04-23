<%--
  Created by IntelliJ IDEA.
  User: jacob
  Date: 4/22/2019
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
    <title>Index</title>
</head>

<body>

<h1>${artistName}</h1>

<h2>
${n0} ${r0}<br>
${n1} ${r1}<br>
${n2} ${r2}<br>
${n3} ${r3}<br>
${n4} ${r4}<br>
</h2>

<%
    String name=request.getParameter("artistName");
%>

<form action="/addEntry" method="get" target="_blank">
    <input type="hidden" name="artistName" value="<%=name%>">
    <input type="submit" value="Add Entry">
</form>

</body>
</html>
