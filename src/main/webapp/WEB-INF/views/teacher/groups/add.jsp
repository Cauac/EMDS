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
    <title>ВК ВГУ :: Группы</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="5"/>
<div class="well offset4 span5">

    <h3 class="center">Новая группа</h3>

    <spring:url var="addGroup" value="/teacher/groups/add"/>
    <form class="form-horizontal" method="post" action="${addGroup}">

        <div id="nameDiv" class="control-group">
            <label class="control-label" for="title">Название:</label>

            <div class="controls">
                <input class="input" type="text" id="title" name="title">
                <span class="help-inline"></span>
            </div>
        </div>

        <div id="specDiv" class="control-group">
            <label class="control-label" for="specId">Специальность:</label>

            <div class="controls">
                <select name="specId" id="specId">
                    <c:forEach var="spec" items="${specialties}">
                        <option value="${spec.id}">${spec.title}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="center">
            <spring:url var="groups" value="/teacher/groups"/>
            <input class="btn btn-primary" type="submit" value="Добавить"/>
            <a class="btn" href="${groups}"> Назад </a>
        </div>
    </form>

</div>
</body>
</html>
