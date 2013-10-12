<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <emds:style/>
    <emds:jquery/>
    <title><emds:title title="Загрузка файла"/></title>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="1"/>
<div class="well center-div span6">

    <h3 class="center">Загрузка файла с успеваемостью</h3><br>

    <spring:url value="/file/uploadProgressFile" var="upload"/>
    <form class="form-horizontal" action="${upload}" method="post" enctype="multipart/form-data">

        <div id="facultyDiv" class="control-group">
            <label class="control-label">Факультет:</label>

            <div class="controls">
                <select name="faculty" id="faculty">
                    <c:forEach var="fac" items="${faculties}">
                        <option value="${fac}">${fac}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="controls">
            <input name="file" type="file"/>
        </div>
        <br>
        <div class="center">
            <spring:url var="abiturients" value="/abiturients"/>
            <input class="btn btn-primary" type="submit" value="Загрузить файл"/>
            <a class="btn" href="${abiturients}"> Отмена </a>
        </div>
        <br>
    </form>
</div>
</body>
</html>