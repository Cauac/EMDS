<%--  Author: Max --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <emds:style/>
    <title><emds:title title="Средний балл"/></title>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="2"/>

<div style="clear:both;"></div>

<spring:url value="/documents/score" var="documentURL"/>

<div class="well center-div span5">

    <h4 class="center"> ${abiturient.lastName} ${abiturient.firstName}</h4> <br>

    <form method="post" action="${documentURL}" class="form-horizontal">

        <input type="hidden" name="id" id="id" value="${abiturient.id}"/>

        <div id="scoreDiv" class="control-group">
            <label class="control-label" for="commentary">Средний балл</label>

            <div class="controls">
                <input type="text" id="commentary" name="commentary"/>
                <span class="help-inline"></span>
            </div>
        </div>

        <div style="clear: both" class="center">
            <input class="btn btn-primary" type="submit" value="Сохранить"/>
            <spring:url var="abiturients" value="/abiturients"/>
            <a class="btn" href="${abiturients}"> Отмена </a>
        </div>

    </form>
</div>

</body>
</html>