<%--  Author: Max --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <mytags:style/>
    <title>ВК ВГУ :: Ксерокопия паспорта</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="2"/>

<div style="clear:both;"></div>

<spring:url value="/teacher/documents/passport" var="documentURL"/>

<div class="well offset3 span7">

    <h4 class="center"> ${abiturient.lastName} ${abiturient.firstName} :: Ксерокопия паспорта</h4>

    <form method="post" action="${documentURL}">

        <input type="hidden" name="id" id="id" value="${abiturient.id}"/>

        <div id="commentaryDiv" class="control-group">
            <div class="controls">
                <textarea class="input span7" rows="5" maxlength="10000" id="commentary" name="commentary">Дата
                    подачи: ${currentDate}</textarea>
            </div>
        </div>

        <div style="clear: both" class="center">
            <input class="btn btn-primary" type="submit" value="Сохранить"/>
        </div>

    </form>
</div>

</body>
</html>