<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ВК ВГУ :: Личная карточка</title>
    <emds:style/>
    <emds:jquery/>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="3"/>
<spring:url value="/reports/examStatement" var="act"/>
<div class="well offset3 span3">
    <h3 class="center">Параметры отчета Зачетно-экзаменационная ведомость</h3>
    <form name="examStatement" id="examStatement" method="POST" action="${act}">
        <select name="group" id="group">
            <c:forEach var="gr" items="${groups}">
                <option value="${gr.id}">${gr.title}</option>
            </c:forEach>
        </select>
        <br>
        <input class="btn btn-primary" type="submit" value="Создать отчёт"/>
    </form>
</div>
