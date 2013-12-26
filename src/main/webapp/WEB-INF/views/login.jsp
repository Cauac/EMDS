<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Вход - Военная кафедра ВГУ</title>
    <link rel="stylesheet" href="/resources/css/style.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css" type="text/css">
    <link rel="icon" type="image/gif" href="${pageContext.request.contextPath}/resources/images/icon.png">
</head>
<body>
<header class="navbar navbar-inverse navbar-fixed-top" role="banner">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/index">
                Военная кафедра ВГУ
            </a>
        </div>
    </div>
</header>
<div class="row">
    <div class="well .col-md-3 .col-md-offset-3">
        <h3 class="center">Вход в систему</h3>
        <div>
            <form class="center" method="post" action="/j_spring_security_check">
                <p><input class="loginInput" type="text" name="j_username" value="" placeholder="Логин"></p>

                <p><input class="loginInput" type="password" name="j_password" value="" placeholder="Пароль"></p>
                <button class="btn loginButton" type="submit" name="commit">
                    <img width="24px" height="24px" src="/resources/images/icons/39.png"/> Войти
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>