<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>

<%--todo: spring form validation--%>
<%--todo: hide j_spring_security_check--%>
<%--todo: exception catch--%>
<%--todo: repair win/fail tags--%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><emds:title title="Вход"/></title>
    <emds:style/>
</head>
<body>
<emds:header/>
<div class="well center-div span5">
    <h3 class="center">Вход в систему</h3>
    <c:if test="${not empty error}">
        <div class="alert alert-error center-div span2">
            Неверный логин/пароль
        </div>
        <c:remove var="error"/>
    </c:if>
    <div>
        <spring:url var="login" value="/j_spring_security_check"/>
        <form class="center" method="post" action="${login}">
            <p><input class="loginInput" type="text" name="j_username" value="" placeholder="Логин"></p>

            <p><input class="loginInput" type="password" name="j_password" value="" placeholder="Пароль"></p>
            <input class="btn loginButton" type="submit" name="commit" value="Войти">
        </form>
    </div>
</div>
</body>
</html>