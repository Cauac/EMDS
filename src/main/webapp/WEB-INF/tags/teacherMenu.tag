<%@tag pageEncoding="UTF-8" %>
<%@attribute name="number" required="true" type="java.lang.Integer" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="tabbable offset1 span11">
    <ul class="nav nav-tabs">

        <spring:url value="/students" var="students"/>
        <spring:url value="/groups" var="groups"/>
        <spring:url value="/specialties" var="specialties"/>
        <spring:url value="/reports" var="reports"/>
        <spring:url value="/teachers" var="teachers"/>

        <li class="<c:if test="${number==1}"><c:out value="active"/></c:if>">
            <a href="${students}">Студенты</a>
        </li>

        <li class="<c:if test="${number==5}"><c:out value="active"/></c:if>">
            <a href="${groups}">Группы</a>
        </li>

        <li class="<c:if test="${number==4}"><c:out value="active"/></c:if>">
            <a href="${specialties}">Специальности</a>
        </li>

        <li class="<c:if test="${number==3}"><c:out value="active"/></c:if>">
            <a href="${reports}">Отчеты</a>
        </li>

        <li class="pull-right <c:if test="${number==6}"><c:out value='active'/></c:if>">
            <a href="${teachers}">Преподаватели</a>
        </li>
    </ul>
</div>