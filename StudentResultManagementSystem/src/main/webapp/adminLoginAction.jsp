<%@ page import="srmpackage.*" %>
<%@ page import="java.sql.*"%>
<%
  String username=request.getParameter("username");
  String password=request.getParameter("password");
  /* if(username.equalsIgnoreCase("siva")&&password.equalsIgnoreCase("1234"))
  {
    response.sendRedirect("adminHome1.jsp");
  }
  else
  {
  response.sendRedirect("errorAdminLogin.html");
  } *///this is hard coded that means what ever we assaigned user name and password must match with hard coded values like siva and 1234
  Connection con=ConnectionProvider.getCon();
  PreparedStatement pstmt=con.prepareStatement("select * from yvuadmin where username=? and password=?");
  pstmt.setString(1,username);
  pstmt.setString(2,password);
  ResultSet rs=pstmt.executeQuery();
  if(rs.next()){
	  response.sendRedirect("adminHome.html");
  }
  else
  {
	  response.sendRedirect("errorAdminLogin.html");
  }  
  %>