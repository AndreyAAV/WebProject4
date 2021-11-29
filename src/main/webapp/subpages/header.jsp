
<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table>
    <tr>
        <c:choose>
            <c:when test="${not empty user}">
                <td>
                    <p>User: <a href="JavaScript:sendSectionForm('user_id')">${user.login}</a></p>
                </td>
                <td>
                    <p><a href="<c:url value="<%= AppConstant.LOGOUT_CONT %>"/>">Logout</a></p>
                </td>
            </c:when>
            <c:otherwise>
                <td>
                    <p>User: guest</p>
                </td>
                <td>
                    <p><a href="<c:url value="<%= AppConstant.LOGIN_JSP %>"/>">LogIn</a></p>
                </td>
                <td>
                    <p><a href="<c:url value="<%= AppConstant.REGISTRATION_JSP %>"/>">Registration</a></p>
                </td>
            </c:otherwise>
        </c:choose>
    </tr>
</table>


