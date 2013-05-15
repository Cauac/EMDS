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
    <title>ВК ВГУ :: Преподаватели</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="6"/>
<mytags:newAccount/>

<c:if test="${fn:length(teachers) gt 0}">
    <table class="table table-condensed offset1 span11">
        <tr class="thead">
            <th>ФИО</th>
            <th>Воинское звание</th>
            <th>Логин</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach var="teacher" items="${teachers}">
            <tr class="tbody">
                <td><c:out value="${teacher.lastName}"/> <c:out value="${teacher.firstName}"/> <c:out
                        value="${teacher.middleName}"/></td>
                <td><c:out value="${teacher.rank}"/></td>
                <td><c:forEach items="${users}" var="user">
                    <c:if test="${user.personId eq teacher.id}">
                        <c:out value="${user.login}"/>
                    </c:if>
                </c:forEach></td>
                <td><c:if test="${teacher.chief}"><i class="icon-flag"></i></c:if></td>
                <td>
                    <spring:url var="editTeacher" value="/teachers/edit">
                        <spring:param name="id" value="${teacher.id}"/>
                    </spring:url>
                    <a href="${editTeacher}">
                        <i title="Редактировать" class="icon-edit"></i>
                    </a>
                </td>
                <td>
                    <spring:url var="removeTeacher" value="/teachers/remove">
                        <spring:param name="id" value="${teacher.id}"/>
                    </spring:url>
                    <a onclick="return confirm('Вы действительно хотите удалить преподавателя?')"
                       href="${removeTeacher}">
                        <i title="Удалить преподавателя" class="icon-remove"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<div style="clear: both" class="center">
    <spring:url var="addTeacher" value="/teachers/add"/>
    <spring:url var="chief" value="/teachers/chief"/>
    <a class="btn btn-primary" href="${addTeacher}">
        <i class="icon-plus icon-white"></i> Добавить преподавателя
    </a>
    <a class="btn btn-info" href="${chief}">
        <i class="icon-flag"></i> Задать начальника кафедры
    </a>
</div>

</body>
</html>
