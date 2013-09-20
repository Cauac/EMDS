<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><emds:title title="Зачетно-экзаменационная ведомость"/></title>
    <emds:style/>
    <emds:jquery/>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="3"/>
<spring:url value="/reports/generateReport" var="generate"/>
<div class="well center-div span6">

    <h3 class="center">Зачетно-экзаменационная ведомость</h3>

    <form:form class="form-horizontal" method="POST" action="${generate}" modelAttribute="form">

        <form:hidden path="formType"/>

        <div id="groupDiv" class="control-group">
            <label class="control-label">Группа:</label>

            <div class="controls">
                <form:select path="group">
                    <form:options items="${groups}" itemValue="id" itemLabel="title"/>
                </form:select>
                <span class="help-inline"></span>
            </div>
        </div>

        <div id="teachersDiv" class="control-group">
            <label class="control-label">Преподаватели:</label>

            <div class="controls">
                <form:select path="teachers" multiple="multiple">
                    <form:options items="${teachers}" itemValue="id" itemLabel="lastName"/>
                </form:select>
                <span class="help-inline"></span>
            </div>
        </div>

        <div class="center">
            <spring:url var="reports" value="/reports"/>
            <input class="btn btn-primary" type="submit" value="Создать отчет"/>
            <a class="btn" href="${reports}"> Отмена </a>
        </div>

    </form:form>

</div>
