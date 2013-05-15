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
    <title>ВК ВГУ :: ${group.title}</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="5"/>
<div class="well offset4 span5">

    <h3 class="center">Учебная группа</h3>
    <spring:url var="saveGroup" value="/groups/save"/>
    <form:form action="${saveGroup}" method="post" cssClass="form-horizontal" modelAttribute="group">

        <form:hidden path="id"/>

        <%--<div id="nameDiv" class="control-group <spring:hasBindErrors name="group">error</spring:hasBindErrors>">--%>
        <%--<div id="nameDiv" class="control-group <c:if test="${errors.hasFieldErrors('title')}">error</c:if>">--%>
        <div id="nameDiv"
             class="control-group ${requestScope['org.springframework.validation.BindingResult.group'].hasFieldErrors('title') ? 'error' : ''}">

            <form:label path="title" cssClass="control-label">Название:</form:label>
            <div class="controls">
                <form:input path="title"/>
                <span class="help-inline"><form:errors path="title"/></span>
            </div>
        </div>

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
            <input class="btn btn-primary" type="submit" value="Сохранить"/>
            <a class="btn" href="${groups}"> Отмена </a>
        </div>
    </form:form>

</div>
</body>
</html>
