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
    <title>ВК ВГУ :: Абитуриенты</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="2"/>
<br>
<!--  ✓  ✗  -->

<c:if test="${fn:length(abiturients) eq 0}">
    <br>
</c:if>

<c:if test="${fn:length(abiturients) gt 0}">
    <table class="table table-condensed offset1 span11">
        <tr class="thead">
            <th></th>
            <th>Факультет</th>
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
                            <td style="text-align: center; color: green">
                                <p title="${abiturient.documents.get(document).commentary}">✓</p></td>
                        </c:when>
                        <c:otherwise>
                            <spring:url var="addDocument" value="/teacher/documents/{document}">
                                <spring:param name="document" value="${document.systemTitle}"/>
                                <spring:param name="id" value="${abiturient.id}"/>
                            </spring:url>
                            <td style="text-align: center"><a href="${addDocument}">добавить</a></td>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:choose>
                    <c:when test="${readiness.get(abiturient)}">
                        <spring:url var="studentialize" value="/teacher/abiturients/studentialize">
                            <spring:param name="id" value="${abiturient.id}"/>
                        </spring:url>
                        <td><a href="${studentialize}">
                            <i title="Перевести в студенты" class="icon-forward"></i> </a>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <spring:url value="/teacher/abiturients/remove" var="remove">
                            <spring:param name="id" value="${abiturient.id}"/>
                        </spring:url>
                        <td>
                            <a onclick="return confirm('Вы действительно хотите удалить абитуриента?')"
                               href="${remove}">
                                <i title="Удалить абитуриента" class="icon-remove"></i>
                            </a>
                        </td>
                    </c:otherwise>
                </c:choose>

            </tr>
        </c:forEach>
    </table>
</c:if>

<div class="offset1 span11">
    <spring:url value="/teacher/abiturients/add" var="addAbiturient"/>
    <a style="width: 180px" class="offset4 btn btn-primary" href="${addAbiturient}">
        <i class="icon-plus icon-white"></i> Добавить абитуриента
    </a>
</div>

</body>
</html>
