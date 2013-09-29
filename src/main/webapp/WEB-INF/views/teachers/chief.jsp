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
    <title><emds:title title="Задать начальника"/></title>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="6"/>

<div class="well center-div span7">
    <h3 class="center"><emds:icon icon="33"/>Начальник кафедры</h3>
    <spring:url var="saveChief" value="/teachers/chief"/>

    <form action="${saveChief}" method="post" class="form-horizontal">

        <div id="teacherDiv" class="control-group">
            <label class="control-label" for="id">Преподаватель:</label>

            <div class="controls">
                <select name="id" id="id" class="span4">
                    <c:forEach items="${teachers}" var="teacher">
                        <option value="${teacher.id}"
                                <c:if test="${teacher.chief}">selected</c:if> >
                                ${teacher.lastName} ${teacher.firstName} ${teacher.middleName} </option>
                    </c:forEach>
                </select>
                <span class="help-inline"><form:errors path="number"/></span>
            </div>
        </div>

        <div class="center">
            <spring:url var="teachers" value="/teachers"/>
            <button class="btn" type="submit"> <emds:icon icon="7"/> Сохранить </button>
            <a class="btn btn-info" href="${teachers}"> Назад </a>
        </div>

    </form>
</div>

</body>
</html>