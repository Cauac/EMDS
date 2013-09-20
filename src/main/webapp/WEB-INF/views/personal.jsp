<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><emds:title title="Настройки"/></title>
    <emds:style/>
</head>
<body>
<emds:header/>
<emds:win-fail/>

<div class="well center-div span5">
    <h3 class="center">Изменить пароль</h3>

    <form class="center" method="post" action="./personal">

        <input type="hidden" name="id" value="<c:out value="${spec.id}"/>">

        <div id="oldPassDiv" class="control-group">
            <div class="controls">
                <input class="input" type="password" id="oldPass" name="oldPass" placeholder="Пароль">
                <span class="help-inline"></span>
            </div>
        </div>

        <div id="newPassDiv" class="control-group">
            <div class="controls">
                <input class="input" type="password" id="newPass" name="newPass" placeholder="Новый пароль">
                <span class="help-inline"></span>
            </div>
        </div>

        <div id="confirmDiv" class="control-group">
            <div class="controls">
                <input class="input" type="password" id="confirm" name="confirm" placeholder="Повторите пароль">
                <span class="help-inline"></span>
            </div>
        </div>

        <div class="center">
            <input class="btn btn-primary" type="submit" value="Сохранить"/>
            <a class="btn" href="./index"> На главную </a>
        </div>
    </form>
</div>
</body>
</html>
