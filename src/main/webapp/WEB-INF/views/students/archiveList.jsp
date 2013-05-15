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
    <title>ВК ВГУ :: Студенты</title>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="1"/>
<emds:studentsTabs number="4"/>

<c:choose>
    <c:when test="${fn:length(students) gt 0}">
        <table class="table table-condensed offset2 span9">
            <tr>
                <th>Студент</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <spring:url var="editStudent" value="/students/edit/${student.id}"/>
                    <td><a href="${editStudent}"> <c:out value="${student.lastName}"/>
                        <c:out value="${student.firstName}"/> <c:out value="${student.middleName}"/> </a></td>
                    <td><c:choose>
                        <c:when test="${student.type eq 'reserve'}">
                            Закончил обучение ${student.questionnaire.educationEndDate}
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
                        <spring:url var="removeStudent" value="/students/purge/${student.id}"/>
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
        <div class="offset1 span11" style="text-align: center">
            <h4>Архив пуст</h4>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>
