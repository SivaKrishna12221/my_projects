<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registered Student</title>
    <style>
        body{
          background-color:rgb(110, 233, 110)  ;
          color:rgb(56, 27, 27);
        }
        thead{
            background-color: rgb(143, 178, 143);
            height:40px;
           
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
            border:1px solid black;
        
        }
    </style>
</head>
<body>

    <h1>Registered students</h1>
    <%
    out.println("<a href=adminHome.html>back</a>");
    %>
    <hr 3px>
    
   <table cellpadding="0" cellspacing="0" border="0">
    <tbody>
    <thead>
        <tr>
          <th>Course Name</th>
          <th>Branch Name</th>
          <th>Roll Number</th>
          <th>Name</th>
          <th>Father Name</th>
          <th>Gender</th>
        </tr>
    </thead>
    <tr>
    <%@page import="srmpackage.*" %>
    <%@page import="java.sql.*"%>
    <%try{
    	Connection con=ConnectionProvider.getCon();
    	Statement stmt=con.createStatement();
    	ResultSet rs=stmt.executeQuery("select * from addnewstudent");
        while(rs.next())
        {
        %>
      <td>
      <%=rs.getString(1) %>
    </td>
    
    <td><%=rs.getString(2)%></td>
    <td><%=rs.getString(3) %></td>
    <td><%=rs.getString(4) %></td> 
    <td><%=rs.getString(5) %></td> 
    <td><%=rs.getString(6) %></td>
    </tr>
    </tbody>
    <%}}
    	catch(Exception e)
    {
    		e.printStackTrace();
   
    }%>
   </table>
  
  
</body>
</html>