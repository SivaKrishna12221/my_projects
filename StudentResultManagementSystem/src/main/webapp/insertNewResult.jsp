<%@page import="srmpackage.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%
String rollno = request.getParameter("rollno");
String sanskrit = request.getParameter("number1");
String english = request.getParameter("number2");
String maths = request.getParameter("number3");
String computers = request.getParameter("number4");
String statistics = request.getParameter("number5");
String comppractical = request.getParameter("number6");
String statspractical = request.getParameter("number7");
PrintWriter pw = response.getWriter();

try {
	Connection con = ConnectionProvider.getCon();
	PreparedStatement pstmt = con.prepareStatement("select rollnumber from insertnewresult where rollnumber=?");
	pstmt.setString(1, rollno);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
		response.sendRedirect("errorInsertNewResult.html");
	} else {
		Statement stmt = con.createStatement();
        stmt.executeUpdate("insert into insertnewresult values('" + rollno + "','" + sanskrit + "','" + english + "','"
		+ maths + "','" + computers + "','" + statistics + "','" + comppractical + "','" + statspractical
		+ "')");
		pw.println("<html><body bgcolor=orange text=green><center><br><h1>");
		pw.println("Marks are added to roll number:" + rollno + " successfully<br><br>");
		pw.println("<a href=adminHome.html>click here</a> to go admin home page");
		pw.println("</h1></center></body></html>");
	}
} catch (Exception e) {
	e.printStackTrace();
}
%>