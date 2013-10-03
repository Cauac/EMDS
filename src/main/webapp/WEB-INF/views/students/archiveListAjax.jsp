<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<c:choose>
    <c:when test="${fn:length(students) gt 0}">

        <table class="table table-condensed center-div span10">
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
                                <%-- <c:forEach var="document" items="student.documents">
                                    ${document}
                                </c:forEach> --%>
                                Не проходил обучение
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="${editStudent}">
                            <emds:icon icon="13" text="Редактировать" />
                        </a>
                    </td>
                    <td>
                        <spring:url var="removeStudent" value="/students/purge">
                            <spring:param name="id" value="${student.id}"/>
                        </spring:url>
                        <a onclick="return confirm('Вы действительно хотите удалить студента из системы?')"
                           href="${removeStudent}">
                            <emds:icon icon="118" text="Удалить из системы" />
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </c:when>
    <c:otherwise>
        <div class="center">
            <h5>Нет студентов выбранных категорий</h5>
        </div>
    </c:otherwise>
</c:choose>