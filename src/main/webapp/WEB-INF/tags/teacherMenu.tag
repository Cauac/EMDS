<%@tag pageEncoding="UTF-8" %>
<%@attribute name="number" required="true" type="java.lang.Integer" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>

<div class="tabbable span11 center-div">
    <ul class="nav nav-tabs">

        <spring:url value="/students" var="students"/>
        <spring:url value="/groups" var="groups"/>
        <spring:url value="/specialties" var="specialties"/>
        <spring:url value="/reports" var="reports"/>
        <spring:url value="/teachers" var="teachers"/>

        <li class="<c:if test="${number==1}"><c:out value="active"/></c:if>">
            <a href="${students}"><emds:icon icon="47" text="Студенты"/> Студенты</a>
        </li>

        <li class="<c:if test="${number==5}"><c:out value="active"/></c:if>">
            <a href="${groups}"><emds:icon icon="54" text="Группы"/> Группы</a>
        </li>

        <li class="<c:if test="${number==4}"><c:out value="active"/></c:if>">
            <a href="${specialties}"><emds:icon icon="32" text="Специальности"/> Специальности</a>
        </li>

        <li class="<c:if test="${number==3}"><c:out value="active"/></c:if>">
            <a href="${reports}"><emds:icon icon="34" text="Отчеты"/> Отчеты</a>
        </li>

        <li class="pull-right <c:if test="${number==6}"><c:out value='active'/></c:if>">
            <a href="${teachers}"><emds:icon icon="111" text="Преподаватели"/> Преподаватели</a>
        </li>
    </ul>
</div>