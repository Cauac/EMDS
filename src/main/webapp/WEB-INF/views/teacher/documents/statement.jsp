<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <mytags:style/>
    <title>ВК ВГУ :: Заявление</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="1"/>

<div style="clear:both;"></div>

<spring:url value="/teacher/documents/statement" var="statementURL"/>

<div class="well offset4 span5">

    <h3 class="center"> ${abiturient.lastName} ${abiturient.firstName} : Заявление</h3>

    <form class="form-horizontal" method="post" action="${statementURL}">

        <input type="hidden" name="id" id="id" value="${abiturient.id}"/>

        <div id="commentaryDiv" class="control-group">
            <label class="control-label" for="commentary">Комментарий:</label>

            <div class="controls">
                <textarea class="input" maxlength="10000" id="commentary" name="commentary">Дата
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