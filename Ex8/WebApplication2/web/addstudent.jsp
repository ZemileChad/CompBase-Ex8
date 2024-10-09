<%-- 
    Document   : addstudent
    Created on : 9 Oct 2024, 17:37:32
    Author     : DoubleX
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student Result</title>
    </head>
    <body>
        <h1>ID :<%=request.getAttribute("id")%></h1>
        <h1>NAME :<%=request.getAttribute("name")%></h1>
        <h1>GPA :<%=request.getAttribute("gpa")%></h1>
        <h1>is added</h1>
        <div align="right">
            
            <jsp:include page="table.jsp" flush="true" />
            
        </div>
    </body>
</html>
