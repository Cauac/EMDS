<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ВК ВГУ :: Отчеты</title>
    <mytags:style/>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="3"/>
<div class="well offset1 span10">
    <h3 class="center">Создать отчет</h3>
    <ul class="nav nav-tabs nav-stacked">
        <li>
            <spring:url var="personCard" value="/reports/personCard"/>
            <a href="${personCard}">Личная карточка</a>
        </li>
        <li>
            <spring:url var="examStatement" value="/reports/examStatement"/>
            <a href="${examStatement}">Зачетно-экаменационная ведомость</a>
        </li>

        <li>
            <spring:url var="commissionProtocol" value="/reports/examProtocol"/>
            <a href="${commissionProtocol}">Протокол заседания выпускной экзаменационной комиссии</a>
        </li>
        <li>
            <spring:url var="allowedList" value="/reports/allowedList"/>
            <a href="${allowedList}">Список допущенных</a>
        </li>
    </ul>
</div>
</body>
</html>
