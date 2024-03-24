<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All student Result</title>
    <style>
        body{
            background-color:rgb(125, 229, 125);
            color:rgb(62, 40, 40)

        }
        thead{
            background-color: rgb(175, 194, 175);
            height: 40px;

        }
        th{
          border:1px solid black;
        }
        td{
        border:1px solid black;
        background-color:transparent;
        }
        
        table{
        width:100%;
        border:1px light rgb(69, 46, 46);
        }
    </style>

</head>
<body>
<%@page import="java.io.*" %>
    <%PrintWriter pw=response.getWriter();
      pw.println("<h1>All Student Result</h1>");
      pw.println("<a href=adminHome.html>back</a>");
    
    %>
    <hr>
    <table>
    <tbody>
        <thead>
           <tr>
            <th>
                rollnumber
            </th>
            <th>
                Sanskrit
            </th>
            <th>English</th>
            <th>Maths</th>
            <th>statistics</th>
            <th>computers</th>
            <th>Computer practical</th>
            <th>Statistics practical</th>
           </tr>
        </thead>
        <%@page import="srmpackage.*" %>
        <%@page import="java.sql.*" %>
        <%
           try{
        	   Connection con=ConnectionProvider.getCon();
        	   Statement stmt=con.createStatement();
        	   ResultSet rs=stmt.executeQuery("select * from insertnewresult");
        	   while(rs.next())
        	   {
           
        %>
        <tr>
        <td>
             <%=rs.getString(1) %>
        </td>
        <td><%=rs.getInt(2) %></td>
        <td><%=rs.getInt(3) %></td>
        <td><%=rs.getInt(4) %></td>
        <td><%=rs.getInt(5) %></td>
        <td><%=rs.getInt(6) %></td>
        <td><%=rs.getInt(7) %></td>
        <td><%=rs.getInt(8) %></td></tr>
       
        <%}}
          catch(Exception e)
        { e.printStackTrace();
        
        }
        %>
        </tbody>
        
    </table>
</body>
</html>