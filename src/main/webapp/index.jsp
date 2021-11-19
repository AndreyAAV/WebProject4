
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
            <td>Today</td>
            <td>Tomorrow</td>
            <td>Soon</td>
            <td>Past</td>
            <td>All</td>
        </tr>
    </table>

</body>
</html>
