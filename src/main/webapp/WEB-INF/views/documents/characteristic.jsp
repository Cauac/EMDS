<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <emds:style/>
        <title><emds:title title="Характеристика"/></title>
    </head>
    <body>
        <emds:header/>
        <emds:teacherMenu number="2"/>
        <spring:url value="/documents/characteristic" var="documentURL"/>

        <div style="clear:both;"></div>

        <div class="well center-div span7">
            <h4 class="center"> ${student.lastName} ${student.firstName} :: Характеристика</h4>

            <form:form method="post" action="${documentURL}" modelAttribute="student">
                <form:hidden path="id"/>
                <br>

                <div id="charDiv" class="control-group">
                    <div class="controls">
                        <form:textarea path="characteristic" rows="5" maxlength="10000" cssClass="span7"
                                       placeholder="Характеристика"/>
                    </div>
                </div>

                <div id="commentaryDiv" class="control-group">
                    <div class="controls">
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
        </div>

    </body>
</html>