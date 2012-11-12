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
        <br>
        
        <a class="offset1 btn btn-primary" href="./specialties/add" >
            <i class="icon-plus icon-white"></i> Новая специальность
        </a>
        
        <br> <br>
        
        <c:if test="${fn:length(specialties) gt 0}">
            <table class="table table-condensed table-bordered offset1 span11">
                <tr>
                    <th>Специальность</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="spec" items="${specialties}">
                    <tr>
                        <td><c:out value="${spec.title}"/></td>
                        <td>
                            <a href="./specialty/edit?id=<c:out value="${spec.id}" />">
                                <i title="Edit specialty" class="icon-edit"></i>
                            </a>
                        </td>
                        <td>
                            <a href="./specialty/remove?id=<c:out value="${spec.id}" />">
                                <i title="Remove specialty" class="icon-remove"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <br>
    </body>
</html>
