<%@page import="srmpackage.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%
String course = request.getParameter("course");
String branch = request.getParameter("branch");
String rollnumber = request.getParameter("rollnumber");
String name = request.getParameter("name");
String fathername = request.getParameter("fathername");
String gender = request.getParameter("gender");
try {
	Connection con = ConnectionProvider.getCon();
	PreparedStatement pstmt=con.prepareStatement("select rollnumber from addnewstudent where rollnumber = ? ");
	pstmt.setString(1,rollnumber);
	ResultSet rs=pstmt.executeQuery();
	if(rs.next())
	{
		response.sendRedirect("errorAddNewStudent.html");
	}
	else{
	PrintWriter pw = response.getWriter();
	Statement stmt = con.createStatement();
	stmt.executeUpdate("insert into addnewstudent values('" + course + "','" + branch + "','" + rollnumber + "','"
	+ name + "','" + fathername + "','" + gender + "')");
	pw.println("<html><body bgcolor=orange text=green><center> <br>");
	pw.println("<h1 color=green> Student Details added successfully</h1>");
	pw.println("<a href=adminHome.html>Click here</a> to Admin Home page</h1>");
	pw.println("</center></body></html>");
	}
} catch (Exception e) {
	e.printStackTrace();
}
%>
