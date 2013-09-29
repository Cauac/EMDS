<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><emds:title title="Отчеты"/></title>
    <emds:style/>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="3"/>
<div class="well center-div span6">
    <h3 class="center"><emds:icon icon="1"/>Создать отчет</h3>
    <ul class="nav nav-tabs nav-stacked">
        <li class="center">
            <spring:url var="personCard" value="/reports/personCard"/>
            <a href="${personCard}"><emds:icon icon="1"/>Личная карточка</a>
        </li>
        <li class="center">
            <spring:url var="examStatement" value="/reports/examStatement"/>
            <a href="${examStatement}"><emds:icon icon="44"/>Зачетно-экаменационная ведомость</a>
        </li>
        <li class="center">
            <spring:url var="commissionProtocol" value="/reports/examProtocol"/>
            <a href="${commissionProtocol}"><emds:icon icon="44"/>Протокол заседания выпускной экзаменационной комиссии</a>
        </li>
        <li class="center">
            <spring:url var="allowedList" value="/reports/allowedList"/>
            <a href="${allowedList}"><emds:icon icon="34"/>Список допущенных к экзамену</a>
        </li>
        <li class="center">
            <spring:url var="progressRequest" value="/reports/progressRequest"/>
            <a href="${progressRequest}"><emds:icon icon="31"/>Сведения о успеваемости студентов</a>
        </li>
    </ul>
</div>
</body>
</html>
