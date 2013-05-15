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
    <title>ВК ВГУ :: Редактировать преподавателя</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="6"/>
<div class="well offset4 span5">

    <h3 class="center"><c:out value="${teacher.lastName}"/> <c:out value="${teacher.firstName}"/> <c:out
            value="${teacher.middleName}"/></h3>

    <spring:url var="editTeacher" value="/teachers/edit"/>
    <form class="form-horizontal" method="post" action="${editTeacher}">

        <input type="hidden" name="id" value="<c:out value="${teacher.id}"/>">

        <div id="lastNameDiv" class="control-group">
            <label class="control-label" for="lastName">Фамилия:</label>

            <div class="controls">
                <input class="input" type="text" id="lastName" name="lastName" value="${teacher.lastName}">
                <span class="help-inline"></span>
            </div>
        </div>

        <div id="firstNameDiv" class="control-group">
            <label class="control-label" for="firstName">Имя:</label>

            <div class="controls">
                <input class="input" type="text" id="firstName" name="firstName" value="${teacher.firstName}">
                <span class="help-inline"></span>
            </div>
        </div>

        <div id="middleNameDiv" class="control-group">
            <label class="control-label" for="middleName">Отчество:</label>

            <div class="controls">
                <input class="input" type="text" id="middleName" name="middleName" value="${teacher.middleName}">
                <span class="help-inline"></span>
            </div>
        </div>

        <div id="specDiv" class="control-group">
            <label class="control-label" for="rank">Воинское звание:</label>

            <div class="controls">
                <select name="rank" id="rank">
                    <option value="Лейтенант" <c:if test="${teacher.rank eq 'Лейтенант'}">selected</c:if>>Лейтенант
                    </option>
                    <option value="Ст. лейтенант" <c:if test="${teacher.rank eq 'Ст. Лейтенант'}">selected</c:if>>
                        Ст. лейтенант
                    </option>
                    <option value="Капитан" <c:if test="${teacher.rank eq 'Капитан'}">selected</c:if>>Капитан</option>
                    <option value="Майор" <c:if test="${teacher.rank eq 'Майор'}">selected</c:if>>Майор</option>
                    <option value="Подполковник" <c:if test="${teacher.rank eq 'Подполковник'}">selected</c:if>>
                        Подполковник
                    </option>
                    <option value="Полковник" <c:if test="${teacher.rank eq 'Полковник'}">selected</c:if>>Полковник
                    </option>
                </select>
            </div>
        </div>

        <div class="center">
            <input class="btn btn-primary" type="submit" value="Сохранить"/>
            <spring:url var="teachers" value="/teachers"/>
            <a class="btn" href="${teachers}"> Назад </a>
        </div>
    </form>

</div>
</body>
</html>
