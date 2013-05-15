<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <mytags:style/>
    <title>ВК ВГУ :: Характеристика</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="2"/>

<div style="clear:both;"></div>

<spring:url value="/documents/characteristic" var="documentURL"/>

<div class="well offset3 span7">

    <h4 class="center"> ${abiturient.lastName} ${abiturient.firstName} :: Характеристика</h4>

    <form:form method="post" action="${documentURL}" modelAttribute="abiturient">
        <%--<form method="post" action="${documentURL}">--%>

        <form:hidden path="id"/>
        <%--<input type="hidden" name="id" id="id" value="${abiturient.id}"/>--%>

        <br>

        <div id="charDiv" class="control-group">
            <div class="controls">
                <form:textarea path="characteristic" rows="5" maxlength="10000" cssClass="span7"
                               placeholder="Характеристика"/>
                    <%--<textarea class="input span7" rows="5" maxlength="10000" id="commentary"--%>
                    <%--name="commentary">Дата подачи: ${currentDate}</textarea>--%>
            </div>
        </div>

        <div id="commentaryDiv" class="control-group">
            <div class="controls">
                    <%--<form:textarea path="commentary" rows="5" maxlength="10000"--%>
                    <%--cssClass="span7">Дата подачи: ${currentDate}</form:textarea>--%>
                <textarea class="input span7" rows="3" maxlength="10000" id="commentary"
                          name="commentary">Дата подачи: ${currentDate}</textarea>
            </div>
        </div>

        <div style="clear: both" class="center">
            <input class="btn btn-primary" type="submit" value="Сохранить"/>
            <spring:url var="abiturients" value="/abiturients"/>
            <a class="btn" href="${abiturients}"> Отмена </a>
        </div>

    </form:form>
    <%--</form>--%>
</div>

</body>
</html>