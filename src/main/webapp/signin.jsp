<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
 <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	<div class="min-h-screen bg-gray-300 flex items-center justify-center">
		<form class="bg-gray-500 shadow-md p-10 rounded-lg  flex flex-col " action="Signin" method="post">
			<h3 class="text-3xl font-semibold mb-4 text-white">Sign In</h3>
			<div class="mb-4">
				<label class="text-gray-200">First_Name</label>
				<input type="text" name="first_name" class="rounded-md ml-2 p-2" placeholder="first name">
			</div>
			<div class="mb-4">
				<label class="text-gray-200">Last_Name</label>
				<input type="text" name="last_name" class="rounded-md ml-2 p-2" placeholder="last name">
			</div>
			<div class="mb-4">
				<label class="text-gray-200">Date of birth</label>
				<input type="date" name="date_of_birth" class="rounded-md ml-2 p-2" placeholder="date of birth">
			</div>
			<div class="mb-4">
				<label class="text-gray-200">Contact Number</label>
				<input type="text" name="number" class="rounded-md ml-2 p-2" placeholder="Phone">
			</div>
			<div class="mb-4">
				<label class="text-gray-200">Password</label>
				<input type="password" name="password" class="rounded-md ml-2 p-2" placeholder="password">
			</div>
			<div class="mb-4">
				<label class="text-gray-200">EmployeeID</label>
				<input type="text" name="employee_id" class="rounded-md ml-2 p-2" placeholder="ID">
			</div>
			<div class="mb-4">
				<button type="submit" class="px-4 py-2 bg-gray-200 shadow-md text-gray-600 rounded-lg">Create</button>
			</div>
		</form>
	</div>
</body>
</html>