<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <mytags:style/>
    <title>ВК ВГУ :: Новый поступающий</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="2"/>
<div class="well offset4 span5">

    <h3 class="center">Новый поступающий</h3>

    <form class="form-horizontal" method="post" action="../abiturients/add">

        <div id="lnameDiv" class="control-group">
            <label class="control-label" for="lname">Фамилия:</label>

            <div class="controls">
                <input class="input" type="text" id="lname" name="lname">
                <span class="help-inline"></span>
            </div>
        </div>

        <div id="nameDiv" class="control-group">
            <label class="control-label" for="fname">Имя:</label>

            <div class="controls">
                <input class="input" type="text" id="fname" name="fname">
                <span class="help-inline"></span>
            </div>
        </div>

        <div id="mnameDiv" class="control-group">
            <label class="control-label" for="mname">Отчество:</label>

            <div class="controls">
                <input class="input" type="text" id="mname" name="mname">
                <span class="help-inline"></span>
            </div>
        </div>

        <div id="facultyDiv" class="control-group">
            <label class="control-label" for="faculty">Факультет:</label>

            <div class="controls">
                <select name="faculty" id="faculty">
                    <c:forEach var="fac" items="${faculties}">
                        <option value="${fac}">${fac}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="center">
            <input class="btn btn-primary" type="submit" value="Добавить"/>
            <a class="btn" href="../abiturients"> Назад </a>
        </div>
    </form>

</div>
</body>
</html>
