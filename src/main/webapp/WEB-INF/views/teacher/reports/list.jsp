<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ВК ВГУ :: Отчеты</title>
    <mytags:style/>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="3"/>
<div class="well offset4 span5">
    <h3 class="center">Создать отчет</h3>
    <spring:url var="reports" value="/teacher/reports"/>
    <form action="${reports}" method="POST">
        <select name="id">
            <c:forEach items="${students}" var="student">
                <option value="<c:out value="${student.id}"/>"><c:out value="${student.lastName}"/> <c:out
                        value="${student.firstName}"/></option>
            </c:forEach>
        </select> <br>
        <input type="submit" class="btn btn-primary btn-large" value="Создать">
    </form>
</div>
</body>
</html>
