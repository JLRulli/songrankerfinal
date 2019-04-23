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
    <title>Index</title>
</head>
<center>
<body style="background-color:#FBE8F6">
<br><br><br>
<h1>Top Ranked Songs for ${artistName}</h1>

<h3>
#1  ${n0}   with ${r0} points<br>
#2  ${n1}   with ${r1} points<br>
#3  ${n2}   with ${r2} points<br>
#4  ${n3}   with ${r3} points<br>
#5  ${n4}   with ${r4} points<br>
</h3>

<%
    String name=request.getParameter("artistName");
%>

<form action="addEntry" method="get" target="_blank">
    <input type="hidden" name="artistName" value="<%=name%>">
    <input type="submit" value="Add Entry">
</form>

</body>
</center>
</html>
