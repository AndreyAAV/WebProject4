<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>NEW COURSE</title>
</head>
<body>
    <jsp:include page="subpages/message.jsp"/>
    <%--    форма для создания курса--%>
    <h1>New Course</h1>
    <form method="post" action="<c:url value="<%= AppConstant.COURSE_CREATE_CONT %>"/>">
        <input type="text" name="<%= AppConstant.TITLE_LABEL %>" placeholder="Title"> <br>
        <input type="text" name="<%= AppConstant.SUBTITLE_LABEL %>" placeholder="Subtitle"> <br>
        <input type="text" name="<%= AppConstant.DESCRIPTION_LABEL %>" placeholder="Description"> <br>
        <input type="date" name="<%= AppConstant.DATE_LABEL %>" placeholder="Date"> <br>
        <input type="text" name="<%= AppConstant.PLACE_LABEL %>" placeholder="Place"> <br>
        <select name="<%= AppConstant.TYPE_LABEL %>">
            <option value="<%= AppConstant.CONFERENCE_TYPE %>">Conference</option>
            <option value="<%= AppConstant.TRAINING_TYPE %>">Training</option>
            <option value="<%= AppConstant.LECTURE_TYPE %>">Lecture</option>
        </select> <br>
        <input type="submit" value="Create">

    </form>

</body>
</html>