<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="emds" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <emds:style/>
    <title><emds:title title="Студенты"/></title>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="1"/>
<emds:studentsTabs number="2"/>

<c:choose>
    <c:when test="${fn:length(students) gt 0}">
        <table class="table table-condensed center-div span9">
            <tr>
                <th>Студент</th>
                <th>Специальность</th>
                <th>Группа</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <spring:url var="editStudent" value="/students/edit/${student.id}"/>
                    <td><a href="${editStudent}"> <c:out value="${student.lastName}"/>
                        <c:out value="${student.firstName}"/> <c:out value="${student.middleName}"/> </a></td>
                    <td><c:out value="ВУС ${student.group.specialty.number}"/></td>
                    <td><c:out value="${student.group.title}"/></td>
                    <td>
                        <spring:url var="editStudent" value="/students/edit/${student.id}"/>
                        <a href="${editStudent}">
                            <i title="Редактировать" class="icon-edit"></i>
                        </a>
                    </td>
                    <td>
                        <spring:url var="removeStudent" value="/students/remove/${student.id}"/>
                        <a onclick="return confirm('Отчислить студента?')"
                           href="${removeStudent}">
                            <i title="Отчислить" class="icon-remove"></i>
                        </a>
                    </td>
                    <td>
                        <spring:url var="toOfficer" value="/students/toOfficer">
                            <spring:param name="id" value="${student.id}"/>
                        </spring:url>
                        <a href="${toOfficer}">
                            <i title="Перевести на 2 курс" class="icon-forward"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <div class="center">
            <h5>Нет студентов данной категории</h5>
        </div>
    </c:otherwise>
</c:choose>
<%--<div class="offset1 span11">--%>
<%--<spring:url var="addStudent" value="/students/add"/>--%>
<%--<a class="offset4 btn btn-primary" title="Beta" href="${addStudent}">--%>
<%--<i class="icon-plus icon-white"></i> Добавить студента--%>
<%--</a>--%>
<%--</div>--%>
</body>
</html>
