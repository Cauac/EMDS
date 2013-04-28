<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <mytags:style/>
    <title>ВК ВГУ :: Информация о студенте</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="1"/>
<h1><c:out value="${student.lastName}"/> <c:out value="${student.firstName}"/>
    <c:out value="${student.middleName}"/></h1>

<h1><c:out value="${student.questionnaire.nationality}"/></h1>
</body>
</html>
