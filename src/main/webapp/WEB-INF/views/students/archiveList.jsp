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
<emds:studentsTabs number="4"/>

<c:choose>
    <c:when test="${fn:length(students) gt 0}">
        <table class="table table-condensed center-div span9">
            <tr>
                <th>Студент</th>
                <th>Факультет</th>
                <th>Год поступления</th>
                <th>Результат обучения</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <spring:url var="editStudent" value="/students/edit/${student.id}"/>
                    <td><a href="${editStudent}"> <c:out value="${student.lastName}"/>
                        <c:out value="${student.firstName}"/> <c:out value="${student.middleName}"/> </a></td>
                    <td>${student.questionnaire.faculty}</td>
                    <td>${student.questionnaire.admissionYear}</td>
                    <td><c:choose>
                        <c:when test="${student.type eq 'reserve'}">
                            Лейтенант запаса
                        </c:when>
                        <c:when test="${student.type eq 'dismissed'}">
                            Отчислен
                        </c:when>
                        <c:otherwise>
                            Не проходил обучение
                        </c:otherwise>
                    </c:choose>
                    </td>
                    <td>
                        <a href="${editStudent}">
                            <i title="Редактировать" class="icon-edit"></i>
                        </a>
                    </td>
                    <td>
                        <spring:url var="removeStudent" value="/students/purge">
                            <spring:param name="id" value="${student.id}"/>
                        </spring:url>
                        <a onclick="return confirm('Вы действительно хотите удалить студента из системы?')"
                           href="${removeStudent}">
                            <i title="Удалить" class="icon-remove"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <div class="center">
            <h5>Архив пуст</h5>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>
