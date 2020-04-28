<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authentication</title>
</head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<form action='jloginsession' method='post'>
  <div class="form-group">
<table class="table table-hover table-sm table-bordered col-md-7">
<tr><th align='left'>User-name</th><td><input type='text' class="form-control" name='username'></td></tr>
<tr><th align='left'>Password</th><td><input type='text' class="form-control" name='password'></td><tr>
<tr><td colspan='2'><input type='submit' class="form-control" name='Post' value='Submit' ></td></tr>
</table>
  </div>
</form>
</body>
</html>