<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <emds:style/>
        <title><emds:title title="Справка ВВК"/></title>
    </head>
    <body>
        <emds:header/>
        <emds:teacherMenu number="2"/>

        <div style="clear:both;"></div>

        <spring:url value="/documents/certificate" var="documentURL"/>

        <div class="well center-div span7">

            <h4 class="center"> ${student.lastName} ${student.firstName} :: Справка ВВК</h4>

            <form method="post" action="${documentURL}">

                <input type="hidden" name="id" id="id" value="${student.id}"/>

                <br>

                <div id="commentaryDiv" class="control-group">
                    <div class="controls">
                        <textarea class="input span7" rows="5" maxlength="10000" id="commentary"
                                  name="commentary">Дата подачи: ${currentDate}</textarea>
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