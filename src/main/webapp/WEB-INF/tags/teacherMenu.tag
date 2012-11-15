<%@tag pageEncoding="UTF-8"%>
<%@attribute name="number" required="true" type="java.lang.Integer"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="tabbable offset1 span11">
    <ul class="nav nav-tabs">

        <c:url value="/teacher/students" var="students"/>
        <c:url value="/teacher/abiturients" var="abits" />
        <c:url value="/teacher/reports" var="reports" />
        <c:url value="/teacher/teachers" var="teachers" />
        <c:url value="/teacher/specialties" var="specs" />
        <c:url value="/teacher/groups" var="groups" />


        <li class="<c:if test="${number==1}"><c:out value="active"/></c:if>">
            <a href="${students}">Студенты</a>
        </li>

        <li class="<c:if test="${number==2}"><c:out value="active"/></c:if>">
            <a href="${abits}">Поступающие</a>
        </li>

        <li class="<c:if test="${number==3}"><c:out value="active"/></c:if>">
            <a href="${reports}">Отчеты</a>
        </li>

        <li class="<c:if test="${number==4}"><c:out value="active"/></c:if>">
            <a href="${specs}">Специальности</a>
        </li>

        <li class="<c:if test="${number==5}"><c:out value="active"/></c:if>">
            <a href="${groups}">Группы</a>
        </li>

        <li class="pull-right <c:if test="${number==6}"><c:out value='active'/></c:if>">
            <a href="${teachers}">Преподаватели</a>
        </li>
    </ul>    
</div>