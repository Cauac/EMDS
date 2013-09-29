<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><emds:title title="Ошибка"/></title>
        <emds:style/>
    </head>
    <body>
        <emds:header/>
        <spring:url value="/config" var="config"/>
        <spring:url value="/developers" var="developers"/>
        <div class="well center-div span8">
            <h1>Произошла ошибка!</h1>
            <p class="lead">${text}</p>
            <a class="btn" href="${config}"> Посмотреть конфигурацию приложения </a>
            <a class="btn" href="${developers}"> Связаться с разработчиками </a>
        </div>
    </body>
</html>