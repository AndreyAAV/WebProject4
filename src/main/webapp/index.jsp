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
    <jsp:include page="subpages/message.jsp"/>
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

            <th>Title</th>
            <th>Date</th>
            <th>Author</th>
            <th>Type</th>
        </tr>

        <c:forEach var="course" items="${courses}">
            <tr>

                <td>
                    <a href="JavaScript:sendViewCourseForm(${course.id})">${course.title}</a>
                </td>
                <td>${course.date}</td>
                <td>${course.author}</td>
                <td>${course.type}</td>
            </tr>
        </c:forEach>
    </table>

    <jsp:include page="subpages/footer.jsp"/>

</body>
</html>
