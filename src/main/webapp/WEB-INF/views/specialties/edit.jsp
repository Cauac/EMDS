<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <mytags:style/>
    <title>ВК ВГУ :: ${specialty.title}</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="4"/>
<div class="well offset4 span5">
    <h3 class="center">Специальность</h3>
    <spring:url var="saveSpecialty" value="/specialties/save"/>
    <form:form action="${saveSpecialty}" method="post" cssClass="form-horizontal" modelAttribute="specialty">

        <form:hidden path="id"/>

        <div id="nameDiv" class="control-group <spring:hasBindErrors name="specialty">error</spring:hasBindErrors>">
            <form:label path="title" cssClass="control-label">Название:</form:label>
            <div class="controls">
                <form:input path="title"/>
                <span class="help-inline"><form:errors path="title"/></span>
            </div>
        </div>

        <div class="center">
            <spring:url var="specialties" value="/specialties"/>
            <input class="btn btn-primary" type="submit" value="Сохранить"/>
            <a class="btn" href="${specialties}"> Назад </a>
        </div>

    </form:form>
</div>
</body>
</html>
