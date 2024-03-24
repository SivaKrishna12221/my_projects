<%@page import="java.sql.*" %>
<%@page import="srmpackage.*" %>
<%
  try{
	  String rollnumber=request.getParameter("rollnumber");
	  Connection con=ConnectionProvider.getCon();
	  Statement stmt=con.createStatement();
	  ResultSet rs=stmt.executeQuery("select * from addnewstudent a_student inner join insertnewresult i_result on a_student.rollnumber=i_result.rollnumber and a_student.rollnumber='"+rollnumber+"'");
	  if(rs.next())
	  {
 %>
 <style>
  img{
   border-radius:35px;
    }
 </style>
 <img src="new yvu image.png" align=left width=70px height=70px>
<center><img src="yvu name image2.png" width=70px height=70px>
<img src="vemana image.png" align=right width=70px heigth=70px></center>
<br>
<hr class="new1">
<style>

table{
     width:100%;
     table-layout:fixed;
}
th{
padding:20px 15px;
text-align:left;
font-weight:500;
font-size:12px;
color:white;
text-transform:uppercase;
border:2px solid rgba(255,255,255,0.3);
}
body{
  background-color:lightcyan;
  sfont-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}
</style>
<div class="tbl-header">
  <table cellpadding="0" cellspacing="0	" border="0">
   <thead>
  <tr><th>Institution Name:YVU</th>
    <th>Course Name:<%=rs.getString(1)%></th>
    <th>Branch Name:<%=rs.getString(2)%></th>
    <th><center>Roll Number:<%=rs.getString(3)%></center></th>
    
</tr>
<tr>
<th>Name:<%=rs.getString(4)%></th>
<th>Father Name:<%=rs.getString(5)%></th>
<th>Gender:<%=rs.getString(6)%></th>
<th><a titlt="print screen" alt="print screen" onclick="window.print();" target="_blank" style="cursor:pointer;"><center><img src="print.png"></center></a></th>
</tr>
</thead>
</table>
</div>
<hr class="new1">
<style>
html{
  font-family:arial;
  font-size:25px;
}
td{
  border:2px solid #726E6D;
  padding:13px;
  color:black;
  text-align:center;
}
thead
{
  text-align:center;
  font-weigth:bold;
  color:white;
  background:#625D5D;
  
}
th{height:38px}
table
{
border-collapse:collapse;
}
.footer
{
text-align:left;
font-weight:bold;
}
 tbody>tr:nth-child(odd)
  { 
  background-color:#D1D0CE;
  }
  tfoot{
   background-color:#625D5D;
   }
  
</style>
<head>
<hr class="new1">
<table border=2px>
<thead><tr>
        <th colspan="3">Course</th>
       <th rowspan="2">Type</th>
       <th rowspan="2">Full marks</th>
       <th rowspan="2">Passing Marks</th>
       <th rowspan="2">Obtained Marks</th>
       </tr>
       <tr>
       <th>Code</th>
       <th colspan="2">Name</th>
       </tr>
</thead>
<tbody>
   <tr>
       <td>15091</td>
       <td colspan="2">Sanskrit</td>
       <td>Theory</td>
       <td>75</td>
       <td>35</td>
       <td><%=rs.getInt(8) %></td>
      </tr>
      <tr>
       <td>15092</td>
       <td colspan="2">English</td>
       <td>Theory</td>
       <td>75</td>
       <td>35</td>
       <td><%=rs.getInt(9) %></td>
      </tr>
      <tr>
       <td>15093</td>
       <td colspan="2">Maths</td>
       <td>Theory</td>
       <td>75</td>
       <td>35</td>
       <td><%=rs.getInt(10) %></td>
      </tr>
      <tr>
       <td>15094</td>
       <td colspan="2">Statastics</td>
       <td>Theory</td>
       <td>75</td>
       <td>35</td>
       <td><%=rs.getInt(11)%></td>
      </tr>
      <tr>
       <td>15095</td>
       <td colspan="2">Computer</td>
       <td>Theory</td>
       <td>75</td>
       <td>35</td>
       <td><%=rs.getInt(12) %></td>
      </tr>
      <tr>
       <td>15096</td>
       <td colspan="2">Statistics</td>
       <td>Practical</td>
       <td>30</td>
       <td>15</td>
       <td><%=rs.getInt(13) %></td>
      </tr>
      <tr>
       <td>15097</td>
       <td colspan="2">Computers</td>
       <td>Practical</td>
       <td>75</td>
       <td>35</td>
       <td><%=rs.getInt(14) %></td>
      </tr>
      </tbody>
     
      <tfoot>
      <tr>
        <td colspan="4" class="footer">Total Marks</td>
        <td>510</td>
        <td>205</td>
        <td><%int sum=rs.getInt(8)+rs.getInt(9)+rs.getInt(10)+rs.getInt(11)+rs.getInt(12)+rs.getInt(13)+rs.getInt(14);out.print(sum); %> </td>
      </tr>
      <tr>
        <td colspan="4" class="footer">Percentage</td>
        <td colspan="3"><%out.println(sum*100/510); %></td>
      </tr>
      </tfoot>
</table>
<hr colspan="new1">
 <center><h6>Note: University doesn't own for the errors or omissions, if any, in this statement.
Designed & Developed by ourself only.</h6></center>
  <hr class="new1">
<center><h6>All Right Reserved by myself only: </h6></center> 
  <hr class="new1">
<%}
else
{
response.sendRedirect("errorYvuOneView.html");
}}
 catch(Exception e)
{
	 e.printStackTrace();
}
%>
</body>