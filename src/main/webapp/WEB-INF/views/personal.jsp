<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ВК ВГУ :: Настройки</title>
        <mytags:style/>
    </head>
    <body>
        <mytags:header/>
        <div class="well offset4 span5">
            <h3 class="center">Изменить пароль</h3>
            <form class="form-horizontal" method="post" action="/personal">

                <input type="hidden" name="id" value="<c:out value="${spec.id}"/>">

                <div id="oldPassDiv" class="control-group">
                    <label class="control-label" for="oldPass">Пароль:</label>
                    <div class="controls">
                        <input class="input" type="text" id="oldPass" name="oldPass">
                        <span class="help-inline" ></span>
                    </div>
                </div>

                <div id="newPassDiv" class="control-group">
                    <label class="control-label" for="newPass">Новый пароль:</label>
                    <div class="controls">
                        <input class="input" type="text" id="newPass" name="newPass">
                        <span class="help-inline" ></span>
                    </div>
                </div>

                <div id="confirmDiv" class="control-group">
                    <label class="control-label" for="confirm">Повторите пароль:</label>
                    <div class="controls">
                        <input class="input" type="text" id="confirm" name="confirm">
                        <span class="help-inline" ></span>
                    </div>
                </div>

                <div class="center">
                    <input class="btn btn-primary" type="submit" value="Сохранить"/>
                    <a class="btn" href="../index"> На главную </a>
                </div>
            </form>
        </div>
    </body>
</html>
