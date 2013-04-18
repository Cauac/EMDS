<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytags" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <mytags:style/>
    <title>ВК ВГУ :: Студенты</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="1"/>

<c:if test="${fn:length(students) gt 0}">
    <table class="table table-condensed offset1 span11">
        <tr>
            <th>ФИО</th>
            <th>Специальность</th>
            <th>Группа</th>
            <th>Логин</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <spring:url var="studentInfo" value="/teacher/students/info">
                    <spring:param name="id" value="${student.id}"/>
                </spring:url>
                <td><a href="${studentInfo}"> <c:out value="${student.lastName}"/>
                    <c:out value="${student.firstName}"/> <c:out value="${student.middleName}"/> </a></td>
                <td><c:out value="${student.group.specialty.title}"/></td>
                <td><c:out value="${student.group.title}"/></td>
                <td><c:forEach items="${users}" var="user">
                    <c:if test="${user.personId eq student.id}">
                        <c:out value="${user.login}"/>
                    </c:if>
                </c:forEach></td>
                <td>
                    <spring:url var="editStudent" value="/teacher/students/edit">
                        <spring:param name="id" value="${student.id}"/>
                    </spring:url>
                    <a href="${editStudent}">
                        <i title="Редактировать" class="icon-edit"></i>
                    </a>
                </td>
                <td>
                    <spring:url var="removeStudent" value="/teacher/students/remove">
                        <spring:param name="id" value="${student.id}"/>
                    </spring:url>
                    <a onclick="return confirm('Вы действительно хотите удалить студента?')" href="${removeStudent}">
                        <i title="Удалить студента" class="icon-remove"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<div class="offset1 span11">
    <spring:url var="addStudent" value="/teacher/students/add"/>
    <a class="offset4 btn btn-primary" title="Beta" href="${addStudent}">
        <i class="icon-plus icon-white"></i> Добавить студента
    </a>
</div>
</body>
</html>
