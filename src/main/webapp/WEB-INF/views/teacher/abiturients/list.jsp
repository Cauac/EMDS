<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

<c:if test="${fn:length(abiturients) gt 0}">
    <table class="table table-condensed offset2 span9">
        <tr class="thead">
            <th>ФИО</th>
            <th>Документ</th>
            <th></th>
            <c:if test="${isReady}">
                <th></th>
            </c:if>
        </tr>
        <c:forEach var="abiturient" items="${abiturients}">
            <tr class="tbody">
                <td><c:out value="${abiturient.lastName}"/> <c:out value="${abiturient.firstName}"/>
                    <c:out value="${abiturient.middleName}"/></td>
                <td>

                </td>
                <c:if test="${isReady}">
                    <td><a href="./abiturients/studentialize?id=<c:out value="${abiturient.id}" />">
                        <i title="Перевести в студенты" class="icon-forward"></i> </a>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</c:if>

<div class="offset1 span11">
    <a style="width: 180px" class="offset4 btn btn-primary" href="./abiturients/add">
        <i class="icon-plus icon-white"></i> Добавить абитуриента
    </a>
</div>

</body>
</html>
