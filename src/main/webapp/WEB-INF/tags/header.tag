<%@tag import="by.vsu.emdsproject.common.EMDSContext"%>
<%@tag pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/j_spring_security_logout" var="logout"/>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="#">
                Военная кафедра ВГУ
            </a>
            <sec:authorize ifAnyGranted="ROLE_TEACHER,ROLE_STUDENT">
                <ul class="nav pull-right">
                    <li class="pull-right"><p class="navbar-text"> Вы вошли как: <%= EMDSContext.getInstance().getCurrentUser().getUsername()%> </p></li>
                    <li class="pull-right"><a href="${logout}">Выйти</a></li>
                </ul>
            </sec:authorize>
        </div>
    </div>
</div>