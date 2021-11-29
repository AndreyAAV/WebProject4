
<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<form id="sectionForm" action="<c:url value="<%= AppConstant.COURSE_LIST_CONT %>"/>">
    <input type="hidden" name="<%= AppConstant.SECTION_LABEL %>">
</form>

<form id="viewCourseForm" action="<c:url value="<%= AppConstant.COURSE_VIEW_CONT %>"/>">
    <input type="hidden" name="<%= AppConstant.ID_LABEL %>">
</form>

<script src="js/main.js"></script>