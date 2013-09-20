<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><emds:title title="Сведения о успеваемости студентов"/></title>
    <emds:style/>
    <emds:jquery/>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="3"/>
<spring:url value="/reports/generateReport" var="generate"/>
<div class="well center-div span6">
    <h3 class="center">Сведения о успеваемости студентов</h3>       <br>

    <form:form class="form-horizontal" method="POST" action="${generate}" modelAttribute="form">

        <form:hidden path="formType"/>

        <div id="facultyDiv" class="control-group">
            <label class="control-label" for="faculty">Факультет:</label>

            <div class="controls">
                <form:select path="facultyName" name="faculty" id="faculty">
                    <c:forEach var="fac" items="${faculties}">
                        <option value="${fac}">${fac}</option>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <div class="center">
            <spring:url var="reports" value="/reports"/>
            <input class="btn btn-primary" type="submit" value="Создать отчет"/>
            <a class="btn" href="${reports}"> Отмена </a>
        </div>

    </form:form>
</div>