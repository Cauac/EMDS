<%-- 
    Document   : groupList
    Created on : 01.10.2012, 9:55:32
    Author     : Max
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>Group list</title>
    </head>
    <body>
        <mytags:menu />
        <h1>Group list here!</h1>
        <c:if test="${fn:length(groups) gt 0}">
            <table border=1>
                <tr>
                    <th>Title</th>
                </tr>
                <tr>
                    <th>Speciality</th>
                </tr>
                <c:forEach var="group" items="${groups}">
                    <tr>
                        <td><c:out value="${group.title}"/></td>
                    </tr>
                    <tr>
                        <td><c:out value="${group.speciality}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
