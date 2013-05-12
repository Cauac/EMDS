<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ВК ВГУ :: Протокол экзаменационной комиссии</title>
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
            padding:0;
            width: 206px;
        }
    </style>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="3"/>
<spring:url value="/reports/examProtocol" var="act"/>
<div class="well offset3 span6">
    <h3 class="center">"Протокол экзаменационной комиссии"</h3>

    <h3 class="center">Параметры отчета</h3>

    <form:form  name="examStatement" id="examProtocol" method="POST" action="${act}">
        <p>Группа: </p>
        <select name="group" id="group">
            <c:forEach var="gr" items="${groups}">
                <option value="${gr.id}">${gr.title}</option>
            </c:forEach>
        </select>
        <br>

        <p>Председатель экзаменационной комиссии: </p>
        <div class="select-and-input">
            <select class="btn btn-primary" name="selectName1" onclick="parentNode.getElementsByTagName('input')[0].value=value">
                <c:forEach var="teacher" items="${teachers}">
                    <option value="${teacher}">${teacher}</option>
                </c:forEach>
            </select>
            <input class="large" type="text" name="member"/>
        </div>
        <br>

        <p>Председатель подкомиссии: </p>
        <div class="select-and-input">
            <select class="btn btn-primary" name="selectName2" onclick="parentNode.getElementsByTagName('input')[0].value=value">
                <c:forEach var="teacher" items="${teachers}">
                    <option value="${teacher}">${teacher}</option>
                </c:forEach>
            </select>
            <input class="large" type="text" name="member"/>
        </div>
        <br>

        <p>Члены экзаменационной комиссии: </p>
        <div class="select-and-input">
            <select class="btn btn-primary" name="selectName3" onclick="parentNode.getElementsByTagName('input')[0].value=value">
                <c:forEach var="teacher" items="${teachers}">
                    <option value="${teacher}">${teacher}</option>
                </c:forEach>
            </select>
            <input class="large" type="text" name="member"/>
        </div>
        <br>
        <div class="select-and-input">
            <select class="btn btn-primary" name="selectName4" onclick="parentNode.getElementsByTagName('input')[0].value=value">
                <c:forEach var="teacher" items="${teachers}">
                    <option value="${teacher}">${teacher}</option>
                </c:forEach>
            </select>
            <input class="large" type="text" name="member"/>
        </div>
        <br>


        <input class="btn btn-primary" type="submit" value="Создать отчёт"/>
    </form:form>
</div>
