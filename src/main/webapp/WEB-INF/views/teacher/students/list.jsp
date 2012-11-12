<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <mytags:style/>
        <title>ВК ВГУ :: Студенты</title>
    </head>
    <body>
        <mytags:header/>
        <mytags:teacherMenu number="1" />
        
        
        <c:if test="${fn:length(students) gt 0}">
	<table class="table table-condensed table-bordered offset1 span11">
		<tr>
			<th>Login</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="student" items="${students}">
			<tr>
				<td><c:out value="${student.login}" /></td>
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
