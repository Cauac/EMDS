<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ВК ВГУ :: Список допущенных</title>
    <emds:style/>
    <emds:jquery/>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="3"/>
<spring:url value="/reports/allowedList" var="act"/>
<div class="well offset3 span6">
    <h3 class="center">"Список допущенных"</h3>
    <h3 class="center">Параметры отчета</h3>
    <form name="examStatement" id="examStatement" method="POST" action="${act}">
        <p>Группа: </p>
        <select name="group" id="group">
            <c:forEach var="gr" items="${groups}">
                <option value="${gr.id}">${gr.title}</option>
            </c:forEach>
        </select>
        <br>
        <input class="btn btn-primary" type="submit" value="Создать отчёт"/>
    </form>
</div>