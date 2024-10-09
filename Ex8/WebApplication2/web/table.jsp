<%-- 
    Document   : table
    Created on : 9 Oct 2024, 15:30:34
    Author     : DoubleX
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.StudentTable"%>
<%@page import="java.util.List"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Table Page</title>
    </head>
    <jsp:useBean id="std" class="model.Student" scope="request"/>
     <%
                       
            List<Student> stdList = StudentTable.findAllStudent();
            Iterator<Student> itr = stdList.iterator();
            
     %>
    <body>
        <h1>Student List</h1>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>GPA</th>
          </tr>
          <%
              
               while(itr.hasNext()) {
                   std = itr.next();
                   out.println("<tr>");
                   out.println("<td> "+ std.getId() + "</td>");
                   out.println("<td> "+ std.getName() + "</td>");
                   out.println("<td> "+ std.getGpa() + "</td>");
                   out.println("<tr>");
               }
          %>
    </table>
    <a href="index.html">Back to AddStudent</a>
    </body>
</html>
