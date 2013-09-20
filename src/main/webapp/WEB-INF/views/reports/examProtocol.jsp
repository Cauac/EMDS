<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><emds:title title="Протокол экзаменационной комиссии"/></title>
    <emds:style/>
    <emds:jquery/>
    <style type="text/css">
        .select-and-input {
            position: relative;
            height: 30px;
            width: 236px;
        }

        .select-and-input select {
            position: absolute;
            z-index: 0;
            top: 0;
            left: 0;
            height: 26px;
            width: 236px;
        }

        .select-and-input input {
            position: absolute;
            z-index: 1;
            top: 0;
            left: 0;
            height: 24px;
            padding: 0;
            width: 206px;
        }

    </style>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="3"/>
<spring:url value="/reports/generateReport" var="generate"/>
<div class="well center-div span6">
    <h3 class="center">Протокол экзаменационной комиссии</h3>     <br>

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
        <br>

        <div id="commanderDiv" class="control-group">
            <label class="control-label">Председатель комиссии:</label>

            <div class="controls select-and-input">
                <select class="btn btn-primary" name="selectName1"
                        onclick="parentNode.getElementsByTagName('input')[0].value=value">
                    <c:forEach var="teacher" items="${teachers}">
                        <option value="${teacher}">${teacher}</option>
                    </c:forEach>
                </select>
                <form:input path="members" class="large" type="text" name="member"/>
                <span class="help-inline"></span>
            </div>
        </div>

        <div id="secCommanderDiv" class="control-group">
            <label class="control-label">Председатель подкомиссии:</label>

            <div class="controls select-and-input">
                <select class="btn btn-primary" name="selectName2"
                        onclick="parentNode.getElementsByTagName('input')[0].value=value">
                    <c:forEach var="teacher" items="${teachers}">
                        <option value="${teacher}">${teacher}</option>
                    </c:forEach>
                </select>
                <form:input path="members" class="large" type="text" name="member"/>
                <span class="help-inline"></span>
            </div>
        </div>


        <div id="member1Div" class="control-group">
            <label class="control-label">Члены экзаменационной комиссии:</label>

            <div class="controls select-and-input">
                <select class="btn btn-primary" name="selectName3"
                        onclick="parentNode.getElementsByTagName('input')[0].value=value">
                    <c:forEach var="teacher" items="${teachers}">
                        <option value="${teacher}">${teacher}</option>
                    </c:forEach>
                </select>
                <form:input path="members"  class="large" type="text" name="member"/>
            </div>

            <div class="controls select-and-input">
                <select class="btn btn-primary" name="selectName4"
                        onclick="parentNode.getElementsByTagName('input')[0].value=value">
                    <c:forEach var="teacher" items="${teachers}">
                        <option value="${teacher}">${teacher}</option>
                    </c:forEach>
                </select>
                <form:input path="members" class="large" type="text" name="member"/>
            </div>
        </div>


        <div class="center">
            <spring:url var="reports" value="/reports"/>
            <input class="btn btn-primary" type="submit" value="Создать отчет"/>
            <a class="btn" href="${reports}"> Отмена </a>
        </div>

    </form:form>
</div>
