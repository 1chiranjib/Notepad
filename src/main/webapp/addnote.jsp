<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
  <body>
    <div class="container"><%@include file="navbar.jsp"%>
    	<form action="savenote" method="post">
		  <div class="form-group navbar-expand-lg">
		    <label for="exampleInputEmail1">Your Name</label>
		    <input required type="text" class="form-control" id="uname" aria-describedby="emailHelp" placeholder="Enter your name" name="uname">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputEmail1">Title</label>
		    <input required type="text" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter title" name="title">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">Note</label>
		    <textarea required type="text" class="form-control" id="note" placeholder="Type your note here.." style="height: 250px" name="note"></textarea>
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>