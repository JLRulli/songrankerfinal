<%--
  Created by IntelliJ IDEA.
  User: jacob
  Date: 4/23/2019
  Time: 3:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Entry</title>
</head>
<center>
<body style="background-color:#FBE8F6">
<br><br><br>

<h2>Add you top songs for ${artistName}</h2>
<br>

<%
    String name=request.getParameter("artistName");
%>

<form action="UpdateEntries" method="get" target="_blank">
    <input type="hidden" name="artistName" value="<%=name%>">
    #1 <input type="text" name="s1"><br><br>
    #2 <input type="text" name="s2"><br><br>
    #3 <input type="text" name="s3"><br><br>
    #4 <input type="text" name="s4"><br><br>
    #5 <input type="text" name="s5"><br><br><br>
    <input type="submit" value="Submit">
</form>

</body>
</center>
</html>
