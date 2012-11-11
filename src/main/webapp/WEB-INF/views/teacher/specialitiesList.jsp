<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <mytags:style/>
        <title>ВК ВГУ :: Специальности</title>
    </head>
    <body>
        <mytags:header/>
        <mytags:teacherMenu number="4" />
        <c:if test="${fn:length(specialities) gt 0}">
            <table class="table table-condensed table-bordered offset1 span11">
                <tr>
                    <th>Title</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="spec" items="${specialities}">
                    <tr>
                        <td><c:out value="${spec.title}"/></td>
                        <td>
                            <a href="./editSpeciality?id=<c:out value="${spec.id}" />">
                                <i title="Edit speciality" class="icon-edit"></i>
                            </a>
                        </td>
                        <td>
                            <a href="./remSpeciality?id=<c:out value="${spec.id}" />">
                                <i title="Remove speciality" class="icon-remove"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <br>
        <a href="./addSpeciality" >
            <i title="Add speciality" class="icon-adjust"></i>
        </a>
    </body>
</html>
