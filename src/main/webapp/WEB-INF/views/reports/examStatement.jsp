<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ВК ВГУ :: Зачетно-экзаменационная ведомость</title>
    <emds:style/>
    <emds:jquery/>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="3"/>
<spring:url value="/reports/examStatement" var="statement"/>
<div class="well offset3 span6">

    <h3 class="center">Зачетно-экзаменационная ведомость</h3>

    <form name="examStatement" class="form-horizontal" id="examStatement" method="POST" action="${statement}">

        <div id="groupDiv" class="control-group">
            <label class="control-label">Группа:</label>

            <div class="controls">
                <select id="group" name="group">
                    <c:forEach var="group" items="${groups}">
                        <option value="${group.id}">${group.title}</option>
                    </c:forEach>
                </select>
                <span class="help-inline"></span>
            </div>
        </div>

        <div class="center">
            <spring:url var="reports" value="/reports"/>
            <input class="btn btn-primary" type="submit" value="Создать отчет"/>
            <a class="btn" href="${reports}"> Отмена </a>
        </div>

    </form>

</div>
