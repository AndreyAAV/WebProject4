<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>LOGIN PAGE</title>
</head>
<body>
  <jsp:include page="subpages/message.jsp"/>
  <h2>Authorization</h2>

  <form method="post" action="<c:url value="<%= AppConstant.AUTHORIZATION_CONT %>"/>">
    <input type="text" name="<%= AppConstant.LOGIN_LABEL %>" placeholder="Login">
    <input type="password" name="<%= AppConstant.PASSWORD_LABEL %>" placeholder="Password">
    <input type="submit" value="LogIn">
  </form>
</body>
</html>
