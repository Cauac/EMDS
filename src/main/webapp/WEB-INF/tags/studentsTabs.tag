<%@tag pageEncoding="UTF-8" %>
<%@attribute name="number" required="true" type="java.lang.Integer" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="tabbable offset4 span6">
    <ul class="nav nav-pills">

        <spring:url value="/students/junior" var="junior"/>
        <spring:url value="/students/officer" var="officer"/>
        <spring:url value="/abiturients" var="abiturients"/>
        <spring:url value="/students/archive" var="archive"/>

        <li class="<c:if test="${number==1}"><c:out value="active"/></c:if>">
            <a href="${abiturients}">Поступающие</a>
        </li>

        <li class="<c:if test="${number==2}"><c:out value="active"/></c:if>">
            <a href="${junior}">1 уровень подготовки</a>
        </li>

        <li class="<c:if test="${number==3}"><c:out value="active"/></c:if>">
            <a href="${officer}">2 уровень подготовки</a>
        </li>

        <li class="<c:if test="${number==4}"><c:out value="active"/></c:if>">
            <a href="${archive}">Архив</a>
        </li>

    </ul>
</div>