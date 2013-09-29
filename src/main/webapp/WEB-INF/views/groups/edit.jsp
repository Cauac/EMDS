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
        <title><emds:title title="${group.title ne '' ? group.title : 'Новая группа'}"/></title>
    </head>
    <body>
        <emds:header/>
        <emds:teacherMenu number="5"/>
        <spring:hasBindErrors name="group">
            <emds:error message="Группа не сохранена. Проверьте правильность заполнения формы."/>
        </spring:hasBindErrors>

        <div class="well center-div span5">

            <h3 class="center"><emds:icon icon="54"/>Учебная группа</h3>
            <spring:url var="saveGroup" value="/groups/save"/>
            <form:form action="${saveGroup}" method="post" cssClass="form-horizontal" modelAttribute="group">

                <form:hidden path="id"/>

                <spring:bind path="title">
                    <div id="nameDiv" class="control-group${status.error ? ' error' : ''}">

                        <form:label path="title" cssClass="control-label">Название:</form:label>
                            <div class="controls">
                            <form:input path="title"/>
                            <span class="help-inline"><form:errors path="title"/></span>
                        </div>
                    </div>
                </spring:bind>

                <div id="specDiv" class="control-group">
                    <form:label path="title" cssClass="control-label">Специальность:</form:label>
                        <div class="controls">
                        <form:select path="specialty">
                            <form:options items="${specialties}" itemValue="id" itemLabel="number"/>
                        </form:select>
                    </div>
                </div>

                <div class="center">
                    <spring:url var="groups" value="/groups"/>

                    <button class="btn" type="submit"> <emds:icon icon="7" text="Сохранить"/> Сохранить </button>
                    <a class="btn btn-info" href="${groups}"> Отмена </a>
                </div>
            </form:form>

        </div>
    </body>
</html>
