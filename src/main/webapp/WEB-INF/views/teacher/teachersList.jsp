<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <mytags:style/>
        <title>ВК ВГУ :: Преподаватели</title>
    </head>
    <body>
        <mytags:header/>
        <mytags:teacherMenu number="6" />
        
        
        <c:if test="${fn:length(teachers) gt 0}">
	<table class="table table-condensed table-bordered offset1 span11">
		<tr>
			<th>Login</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="teacher" items="${teachers}">
			<tr>
				<td><c:out value="${teacher.login}" /></td>
				<td>
					<a href="./editUser?id=<c:out value="${user.id}" />">
						<i title="Edit user" class="icon-edit"></i>
					</a>
				</td>
				<td>
					<a href="./remUser?id=<c:out value="${user.id}" />">
						<i title="Remove user" class="icon-remove"></i>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
        
        
        
    </body>
</html>
