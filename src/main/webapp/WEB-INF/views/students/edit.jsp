<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<%@page contentType="text/html" pageEncoding="utf-8" %>
<%--todo: complete student edition--%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <mytags:style/>
    <title>ВК ВГУ :: Редактировать студента</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="6"/>
<div class="well offset4 span5">

    <h3 class="center"><c:out value="${student.lastName}"/> <c:out value="${student.firstName}"/> <c:out
            value="${student.middleName}"/></h3>

    <spring:url var="editStudent" value="/students/edit"/>
    <form class="form-horizontal" method="post" action="${editStudent}">

        <input type="hidden" name="id" value="<c:out value="${student.id}"/>"/>

        <!--...........-->

        <div class="center">
            <input class="btn btn-primary" type="submit" value="Сохранить"/>
            <spring:url var="students" value="/students"/>
            <a class="btn" href="${students}"> Назад </a>
        </div>
    </form>

</div>
</body>
</html>
