
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="subpages/header.jsp"/>
    <h1>Course ${course.title}</h1>

    <p>Subtitle: ${course.subtitle}</p>
    <p>Description: ${course.description}</p>
    <p>Date: ${course.date}</p>
    <p>Author: ${course.author}</p>
    <p>Status: ${course.status}</p>
    <p>Type: ${course.type}</p>
</body>
</html>
