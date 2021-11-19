<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>REGISTRATION PAGE</title>
</head>
<body>
  <h2>Registration</h2>

  <c:if test="${not empty message}">
    <p style="color: #ff0000">${message}</p>
  </c:if>
  <form method="post" action="<c:url value="<%= AppConstant.REGISTRATION_CONT %>"/>">
    <input type="text" name="<%= AppConstant.LOGIN_LABEL %>" placeholder="Login"> <br>
    <input type="password" name="<%= AppConstant.PASSWORD_LABEL %>" placeholder="Password"> <br>
    <input type="text" name="<%= AppConstant.NAME_LABEL %>" placeholder="Name"> <br>
    <input type="text" name="<%= AppConstant.SURNAME_LABEL %>" placeholder="Surname"> <br>
    <input type="email" name="<%= AppConstant.EMAIL_LABEL %>" placeholder="Email"> <br>
    <input type="submit" value="Registration">
  </form>
</body>
</html>
