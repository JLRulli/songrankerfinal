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
<body>

<h1>Add Entry</h1>

<h2>Add you top songs for ${artistName}</h2>

<%
    String name=request.getParameter("artistName");
%>

<form action="UpdateEntries" method="get" target="_blank">
    <input type="hidden" name="artistName" value="<%=name%>">
    Your Name <input type="text" name="userName"><br>
    #1 <input type="text" name="s1"><br>
    #2 <input type="text" name="s2"><br>
    #3 <input type="text" name="s3"><br>
    #4 <input type="text" name="s4"><br>
    #5 <input type="text" name="s5"><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
