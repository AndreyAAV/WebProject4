<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>HOME PAGE</title>
</head>
<body>
  <jsp:include page="subpages/header.jsp"/>
  <p>Hi, Dear ${user.name} ${user.surname}</p>
</body>
</html>
