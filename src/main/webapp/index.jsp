<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Training portal</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="css/style.css"/>">
</head>
<body>
    <jsp:include page="subpages/header.jsp"/>
    <h2>Hello!</h2>

    <table border="1">
        <tr>
            <td>
                <a href="JavaScript:sendSectionForm('today')">Today</a>
            </td>
            <td>
                <a href="JavaScript:sendSectionForm('tomorrow')">Tomorrow</a>
            </td>
            <td>
                <a href="JavaScript:sendSectionForm('soon')">Soon</a>
            </td>
            <td>
                <a href="JavaScript:sendSectionForm('past')">Past</a>
            </td>
            <td>
                <a href="JavaScript:sendSectionForm('all')">All</a>
            </td>
        </tr>
    </table>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Date</th>
            <th>Author</th>
            <th>Type</th>
        </tr>

        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.id}</td>
                <td>${course.title}</td>
                <td>${course.date}</td>
                <td>${course.author}</td>
                <td>${course.type}</td>
            </tr>
        </c:forEach>
    </table>


    <form id="sectionForm" action="<c:url value="<%= AppConstant.COURSE_LIST_CONT %>"/>">
    </form>
        <script src="js/main.js"></script>

</body>
</html>
