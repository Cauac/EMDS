<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <emds:style/>
        <title><emds:title title="${specialty.number ne '' ? specialty.number : 'Новая специальность'}"/></title>
    </head>
    <body>
        <emds:header/>
        <emds:teacherMenu number="4"/>
        <spring:hasBindErrors name="specialty">
            <emds:error message="Специальность не сохранена. Проверьте правильность заполнения формы."/>
        </spring:hasBindErrors>

        <div class="well center-div span7">
            <h3 class="center"><emds:icon icon="32"/>Специальность</h3>
            <spring:url var="saveSpecialty" value="/specialties/save"/>
            <form:form action="${saveSpecialty}" method="post" cssClass="form-horizontal" modelAttribute="specialty">

                <form:hidden path="id"/>

                <spring:bind path="number">
                    <div id="numberDiv" class="control-group${status.error ? ' error' : ''}">
                        <form:label path="number" cssClass="control-label">ВУС:</form:label>
                            <div class="controls">
                            <form:input path="number" cssClass="span4"/>
                            <span class="help-inline"><form:errors path="number"/></span>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="description">
                    <div id="descriptionDiv" class="control-group${status.error ? ' error' : ''}">
                        <form:label path="description" cssClass="control-label">Описание:</form:label>
                            <div class="controls">
                            <form:input path="description" cssClass="span4"/>
                            <span class="help-inline"><form:errors path="description"/></span>
                        </div>
                    </div>
                </spring:bind>

                <div class="center">
                    <spring:url var="specialties" value="/specialties"/>
                    <button class="btn" type="submit"> <emds:icon icon="7" text="Сохранить"/> Сохранить </button>
                    <a class="btn btn-info" href="${specialties}"> Назад </a>
                </div>

            </form:form>
        </div>
    </body>
</html>
