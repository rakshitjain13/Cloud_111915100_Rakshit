<%@page import="com.rakshitjain13.Employee" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report</title>
 <script src="https://cdn.tailwindcss.com"></script>

</head>
<style>
body{
background: rgb(238,174,202);
background: linear-gradient(90deg, rgba(238,174,202,1) 0%, rgba(148,187,233,1) 100%);
display:flex;
flex-direction:column;
justify-content:center;
align-items:center;
}
</style>
<body>


	<h3  class="text-4xl text-white mt-10">Welcome <em>${first_name}</em></h3>
	<div class="text-2xl text-gray-100 mt-5 tracking-wider font-bold flex flex-col">
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		if(session.getAttribute("first_name")==null){
			response.sendRedirect("login.jsp");
		}
		Employee Obj=new Employee();
		String result=Obj.GetDetails();
		out.println(result);
	%>
</div>
	<form class="mt-10">
		<button type="submit" class="p-2 mx-2 bg-blue-400 text-blue-800 font-semibold rounded-lg">Filter (Type Employee ID  Name): </button>
		<input type="text" name="employee_id" class="p-2 rounded-lg">
	</form>
	<div class="text-2xl text-gray-100 mt-5 tracking-wider font-bold flex flex-col">
		<%
	
			String employee_id=request.getParameter("employee_id");
			if(employee_id!=null && employee_id!=""){
				String res=Obj.GetSalary(employee_id);
				out.println(res);
			}
			
		%>
	</div>
	<div class="text-2xl text-gray-100 mt-5 tracking-wider font-bold flex flex-col">
		<%
	
			 employee_id=request.getParameter("employee_id");
			if(employee_id!=null && employee_id!=""){
				String res=Obj.GetEmployeeDetails(employee_id);
				out.println(res);
			}
			
		%>
	</div>
	<form action="Logout">
		<button type="submit"  class="p-2 mx-2 bg-blue-400 text-blue-800 font-semibold rounded-lg mt-10">Logout</button>
	</form>
</body>
</html> 