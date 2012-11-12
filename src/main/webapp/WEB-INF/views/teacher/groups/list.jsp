<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<!DOCTYPE html>
<html>
    <head>
        <mytags:style />
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>ВК ВГУ :: Группы</title>
    </head>
    <body>
        <mytags:header/>
        <mytags:teacherMenu number="5" />
        <c:if test="${fn:length(groups) gt 0}">
            <table border=1>
                <tr>
                    <th>Группа</th>
                    <th>Специальность</th>
                </tr>
                <c:forEach var="group" items="${groups}">
                    <tr>
                        <td><c:out value="${group.title}"/></td>
                        <td><c:out value="${group.specialty.title}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
