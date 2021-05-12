<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="color: navy; text-align: center;">LoginFrom</h1>
<form:form modelAttribute="userCmd" method="POST">
     UserName::<form:input path="username" /><br>
     password::<form:password path="paasword" /><br>
	<input type="submit" value="login">
</form:form>