<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project DRDO</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>

	<%@page import="java.util.Iterator"%>
	<%@ page import="com.dao.copy.dbConnection"%>
	<%@page import="java.util.ArrayList"%>
	<%@page import="com.projectDRDO.aircraftData"%>
	<%@page import="java.util.Arrays"%>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>

	<nav class="navbar navbar-dark bg-dark fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="/projectDRDO">My Project</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar"
				aria-controls="offcanvasDarkNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1"
				id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
				<div class="offcanvas-header">
					<h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">My
						Project</h5>
					<button type="button" class="btn-close btn-close-white"
						data-bs-dismiss="offcanvas" aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
					<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="/projectDRDO">Home</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="/projectDRDO/Servlet1">Aircraft Data</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>

	<br></br>
	<br></br>
	<div class="container-fluid">
		<div class="alert alert-warning alert-dismissible fade show"
			role="alert">
			<strong></strong>Successfully retrieved all records from database!
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</div>

	<span class="d-inline-block" data-toggle="popover"
		data-content="Disabled popover">
		<button class="btn btn-primary"
			style="pointer-events: none; margin-left: 695px;" type="button"
			disabled>
			Total Time =<%
		if (request.getAttribute("times") != null) // Null check for the object
		{
			String time = request.getAttribute("times").toString();
			out.print(time);
			time = "\0";
		}
		%>Seconds
		</button>
	</span>

	<span class="d-inline-block" data-toggle="popover"
		data-content="Disabled popover">
		<button class="btn btn-primary" style="pointer-events: none;"
			type="button" disabled>
			Total records=
			<%
		if (request.getAttribute("sizes") != null) // Null check for the object
		{
			String size = request.getAttribute("sizes").toString();
			out.print(size);
		}
		%>
			rows
		</button>
	</span>
	<br></br>

	<table class="table table-striped-columns">
		<thead>
			<tr>

				<th scope="col">Total Fatalities</th>
				<th scope="col">Date</th>
				<th scope="col">Aircraft</th>
				<th scope="col">Country</th>
			</tr>
		</thead>
		<tbody>
			<%
			if (request.getAttribute("data") != null) // Null check for the object
			{

				ArrayList<aircraftData> data = (ArrayList)request.getAttribute("data");

				Iterator<aircraftData> iterator = data.iterator(); // Iterator interface

				while (iterator.hasNext()) // iterate through all the data until the last record
				{
					aircraftData Details = iterator.next(); //assign individual employee record to the employee class object
			%>
			<tr>
				<td><%=Details.getTotal_fatalities()%></td>
				<td><%=Details.getDate()%></td>
				<td><%=Details.getAircraft()%></td>
				<td><%=Details.getCountry()%></td>
			</tr>
			<%
			}
			}

			else {
			System.out.println("did not get data object !");
			System.out.println(request.getAttribute("data"));
			}
			%>
		</tbody>
	</table>
</body>
</html>