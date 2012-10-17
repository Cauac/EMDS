<%-- 
    Document   : specialityList
    Created on : 30.09.2012, 13:39:19
    Author     : Max
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Speciality list</title>
    </head>
    <body>
        <mytags:menu />
        <h1>Speciality list here!</h1>
        <c:if test="${fn:length(specialities) gt 0}">
            <table border=1>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                </tr>
                <c:forEach var="spec" items="${specialities}">
                    <tr>
                        <td><c:out value="${spec.id}"/></td>
                        <td><c:out value="${spec.title}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
