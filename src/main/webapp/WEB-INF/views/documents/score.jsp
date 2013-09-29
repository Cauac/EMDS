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

            <h4 class="center"> ${student.lastName} ${student.firstName}</h4> <br>

            <form method="post" action="${documentURL}" class="form-horizontal">

                <input type="hidden" name="id" id="id" value="${student.id}"/>

                <div id="scoreDiv" class="control-group">
                    <label class="control-label" for="commentary">Средний балл</label>

                    <div class="controls">
                        <input type="text" id="commentary" name="commentary"/>
                        <span class="help-inline"></span>
                    </div>
                </div>

                <div class="center">
                    <spring:url var="abiturients" value="/abiturients"/>
                    <button class="btn" type="submit"> <emds:icon icon="7" text="Сохранить"/> Сохранить </button>
                    <a class="btn btn-info" href="${abiturients}"> Отмена </a>
                </div>

            </form>
        </div>

    </body>
</html>