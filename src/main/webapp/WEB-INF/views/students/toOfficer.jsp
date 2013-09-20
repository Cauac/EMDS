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

<div class="well center-div span5">

    <h4 class="center">${student.lastName} ${student.firstName} :: Выбор группы</h4>

    <br>
    <spring:url var="toOfficer" value="/students/toOfficer"/>
    <form class="form-horizontal" method="post" action="${toOfficer}">

        <input type="hidden" name="id" id="id" value="${student.id}"/>

        <div id="groupDiv" class="control-group">
            <label class="control-label" for="groupId">Группа:</label>

            <div class="controls">
                <select name="groupId" id="groupId">
                    <c:forEach var="group" items="${groups}">
                        <option value="${group.id}">${group.title}(ВУС ${group.specialty.number})</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="center">
            <spring:url var="students" value="/students"/>
            <input class="btn btn-primary" type="submit" value="Перевести"/>
            <a class="btn" href="${students}"> Назад </a>
        </div>
    </form>

</div>


</body>
</html>