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

            <h4 class="center">${student.lastName} ${student.firstName} :: Выбор группы</h4>

            <br>
            <spring:url var="studentialize" value="/abiturients/studentialize"/>
            <form class="form-horizontal" method="post" action="${studentialize}">

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
                    <spring:url var="abiturients" value="/abiturients"/>
                    <button class="btn" type="submit"> <emds:icon icon="104" text="Перевести в студенты"/> Перевести в студенты </button>
                    <a class="btn btn-info" href="${abiturients}"> Отмена </a>
                </div>
            </form>

        </div>

    </body>
</html>