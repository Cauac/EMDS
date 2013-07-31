<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<%@page contentType="text/html" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <mytags:style/>
    <title>ВК ВГУ :: Добавить преподавателя</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="6"/>
<div class="well offset4 span5">

    <h3 class="center">Добавить преподавателя</h3>

    <spring:url var="addTeacher" value="/teachers/add"/>
    <form class="form-horizontal" method="post" action="${addTeacher}">

        <div id="lastNameDiv" class="control-group">
            <label class="control-label" for="lastName">Фамилия:</label>

            <div class="controls">
                <input class="input" type="text" id="lastName" name="lastName">
                <span class="help-inline"></span>
            </div>
        </div>

        <div id="firstNameDiv" class="control-group">
            <label class="control-label" for="firstName">Имя:</label>

            <div class="controls">
                <input class="input" type="text" id="firstName" name="firstName">
                <span class="help-inline"></span>
            </div>
        </div>

        <div id="middleNameDiv" class="control-group">
            <label class="control-label" for="middleName">Отчество:</label>

            <div class="controls">
                <input class="input" type="text" id="middleName" name="middleName">
                <span class="help-inline"></span>
            </div>
        </div>

        <div id="nameDiv" class="control-group">
            <label class="control-label" for="rank">Звание:</label>

            <div class="controls">
                <select name="rank" id="rank">
                    <option value="Младший лейтенант">Младший лейтенант</option>
                    <option value="Лейтенант">Лейтенант</option>
                    <option value="Старший лейтенант">Старший лейтенант</option>
                    <option value="Капитан">Капитан</option>
                    <option value="Майор">Майор</option>
                    <option value="Подполковник">Подполковник</option>
                    <option value="Полковник">Полковник</option>
                </select>
            </div>
        </div>

        <div class="center">
            <input class="btn btn-primary" type="submit" value="Добавить"/>
            <spring:url var="teachers" value="/teachers"/>
            <a class="btn" href="${teachers}"> Назад </a>
        </div>

    </form>
</div>
</body>
</html>
