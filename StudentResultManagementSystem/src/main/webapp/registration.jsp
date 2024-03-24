<%@ page import="srmpackage.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>

<%
  String username=request.getParameter("username");
  String password=request.getParameter("password1");
  Connection con=ConnectionProvider.getCon();
  PreparedStatement pstmt=con.prepareStatement("select * from yvuadmin where username='"+username+"' and password='"+password+"'");
  ResultSet rs=pstmt.executeQuery();
  PrintWriter pw=response.getWriter();
  if(rs.next())
  {
	 //response.sendRedirect("errorRegistration.html");
	   String errorhtml="errorRegistrations.html";
       RequestDispatcher rd=request.getRequestDispatcher(errorhtml);
       rd.forward(request,response); 
  }
  else{
  PreparedStatement pstmt2=con.prepareStatement("insert into yvuadmin values(?,?)");
  pstmt2.setString(1,username);
  pstmt2.setString(2,password);
  pstmt2.executeUpdate();
    /*  //response.sendRedirect("index.html");
     String indexhtml="index.html";
     RequestDispatcher rd=request.getRequestDispatcher(indexhtml);
     rd.forward(request,response); */
  }
  
   PrintWriter pw2=response.getWriter();
  
  pw.println("<html><body bgcolor=orange ><center>");
  pw.println("<h1>you have registered successfully</h1>"); 
  pw.println(" <a href=adminLogin.html>click here</a> go to adminlogin page<br><br>");
  pw.println("<a href=index.html>click here</a> to home page");
  pw.println("</center></body>");
 
 
  %>
  