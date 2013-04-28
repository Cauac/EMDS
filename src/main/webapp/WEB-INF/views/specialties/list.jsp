<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <mytags:style/>
    <title>ВК ВГУ :: Специальности</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="4"/>
<br>

<c:if test="${fn:length(specialties) gt 0}">
    <table class="table table-condensed offset3 span7">
        <tr class="thead">
            <th>Специальность</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach var="spec" items="${specialties}">
            <tr class="tbody">
                <td><c:out value="${spec.title}"/></td>
                <td>
                    <spring:url var="editSpeciality" value="/specialties/edit">
                        <spring:param name="id" value="${spec.id}"/>
                    </spring:url>
                    <a href="${editSpeciality}">
                        <i title="Редактировать" class="icon-edit"></i>
                    </a>
                </td>
                <td>
                    <spring:url var="removeSpeciality" value="/specialties/remove">
                        <spring:param name="id" value="${spec.id}"/>
                    </spring:url>
                    <a onclick="return confirm('Вы действительно хотите удалить специальность?')"
                       href="${removeSpeciality}">
                        <i title="Удалить" class="icon-remove"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<div class="offset1 span11">
    <spring:url var="addSpeciality" value="/specialties/edit"/>
    <a class="offset4 btn btn-primary" href="${addSpeciality}">
        <i class="icon-plus icon-white"></i> Добавить специальность
    </a>
</div>

</body>
</html>
