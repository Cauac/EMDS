<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <emds:style/>
    <title><emds:title title="Перевод в студенты"/></title>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="1"/>
<div class="well center-div span5">

    <h4 class="center">${abiturient.lastName} ${abiturient.firstName} :: Выбор группы</h4>

    <br>
    <spring:url var="studentialize" value="/abiturients/studentialize"/>
    <form class="form-horizontal" method="post" action="${studentialize}">

        <input type="hidden" name="id" id="id" value="${abiturient.id}"/>

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
            <spring:url var="abiturients" value="/abiturients"/>
            <input class="btn btn-primary" type="submit" value="Перевести в студенты"/>
            <a class="btn" href="${abiturients}"> Назад </a>
        </div>
    </form>

</div>

</body>
</html>