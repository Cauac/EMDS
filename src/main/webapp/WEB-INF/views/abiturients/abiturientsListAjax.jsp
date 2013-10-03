<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="emds" %>

<c:choose>
    <c:when test="${fn:length(abiturients) gt 0}">
        <table class="table table-condensed table-bordered span11 center-div">
            <tr class="thead">
                <th style="width: 200px"></th>
                <th><p style="text-align: center">Факультет</p></th>
                <c:forEach var="document" items="${documents}">
            <th><p style="text-align: center"><c:out value="${document.title}"/></p></th>
        </c:forEach>
    <th></th>
</tr>
<c:forEach var="abiturient" items="${abiturients}">
    <tr class="tbody">
        <td><c:out value="${abiturient.lastName}"/> <c:out value="${abiturient.firstName}"/>
            <c:out value="${abiturient.middleName}"/></td>

        <td><p style="text-align: center"><c:out value="${abiturient.questionnaire.faculty}"/></p></td>

        <c:forEach var="document" items="${documents}">
            <c:choose>
                <c:when test="${abiturient.documents.get(document).brought eq true}">
                    <c:choose>
                        <c:when test="${document.systemTitle ne 'score'}">
                            <td style="text-align: center; color: green">
                                <p title="${abiturient.documents.get(document).commentary}">✓</p></td>
                            </c:when>
                            <c:otherwise>
                            <td style="text-align: center;"> ${abiturient.documents.get(document).commentary} </td>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <spring:url var="addDocument" value="/documents/{document}">
                        <spring:param name="document" value="${document.systemTitle}"/>
                        <spring:param name="id" value="${abiturient.id}"/>
                    </spring:url>
                    <td style="text-align: center"><a href="${addDocument}">добавить</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:choose>
            <c:when test="${readiness.get(abiturient)}">
                <spring:url var="studentialize" value="/abiturients/studentialize">
                    <spring:param name="id" value="${abiturient.id}"/>
                </spring:url>
                <td style="width:30px"><a href="${studentialize}">
                        <emds:icon icon="104" text="Перевести в студенты" />
                    </a>
                </td>
            </c:when>
            <c:otherwise>
                <spring:url value="/abiturients/remove" var="remove">
                    <spring:param name="id" value="${abiturient.id}"/>
                </spring:url>
                <td style="width:30px">
                    <a onclick="return confirm('Вы действительно хотите перенести информацию о студенте в архив?')"
                       href="${remove}">
                        <emds:icon icon="115" text="Отказать в приеме" />
                    </a>
                </td>
            </c:otherwise>
        </c:choose>

    </tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
    <h5 class="center">Нет абитуриентов выбранных факультетов</h5>
</c:otherwise>
</c:choose>