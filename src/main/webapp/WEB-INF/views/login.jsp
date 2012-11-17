<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ВК ВГУ :: Вход</title>
        <mytags:style />
        <!--<script type="text/javascript" src="resources/scripts/jquery-1.7.2.js">  </script>-->
    </head>
    <body>
        <mytags:header />
        <div class="well offset4 span5">
            <h3 class="center">Вход в систему</h3>
            <c:if test="${not empty error}">
                <div class="alert alert-error offset1 span2">   
                    Неверный логин/пароль
                </div>
                <c:remove var="error"/>
            </c:if>
            <div>
                <form class="center" method="post" action="./j_spring_security_check">
                    <p><input class="loginInput" type="text" name="j_username" value="" placeholder="Логин"></p>
                    <p><input class="loginInput" type="password" name="j_password" value="" placeholder="Пароль"></p>
                    <input class="btn loginButton" type="submit" name="commit" value="Войти">
                </form>
            </div>
        </div>
    </body>
</html>