<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<spring:url value="/exit" var="logout"/>
<spring:url value="/index" var="index"/>
<spring:url value="/personal" var="personal"/>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="${index}">
                Военная кафедра ВГУ
            </a>
            <sec:authorize ifAnyGranted="ROLE_TEACHER,ROLE_STUDENT">
                <ul class="nav pull-right">
                    <li class="pull-right"><p class="navbar-text">
                        <a href="${personal}"><c:out value="${currentName.lastName}"/> <c:out
                                value="${currentName.firstName}"/> <c:out value="${currentName.middleName}"/></a></p>
                    </li>
                    <li class="pull-right"><a href="${logout}">Выйти</a></li>
                </ul>
            </sec:authorize>
        </div>
    </div>
</div>