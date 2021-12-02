<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>HOME PAGE</title>
</head>
<body>
  <jsp:include page="subpages/header.jsp"/>
  <jsp:include page="subpages/message.jsp"/>
  <p>Hi, Dear ${user.name} ${user.surname}</p>

  <h2>Your courses</h2>
  <table border="1">
    <tr>
      <th>Title</th>
      <th>Date</th>
      <th>Author</th>
      <th>Type</th>
      <th></th>
    </tr>

    <c:forEach var="course" items="${courses}">
      <tr>

        <td>
          <a href="JavaScript:sendViewCourseForm(${course.id})">${course.title}</a>
        </td>
        <td>${course.date}</td>
        <td>${course.author}</td>
        <td>${course.type}</td>
        <td>
          <button>Delete</button>
          /
          <button>Refactor</button>
        </td>
      </tr>
    </c:forEach>
  </table>
  <p>
  <a href="<c:url value="<%= AppConstant.NEW_COURSE_JSP %>"/>">New course</a>
  </p>
  <jsp:include page="subpages/footer.jsp"/>
</body>
</html>
