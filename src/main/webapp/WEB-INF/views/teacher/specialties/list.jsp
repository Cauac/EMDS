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

        <c:if test="${fn:length(specialties) gt 0}">
            <table class="table table-condensed offset2 span9">
                <tr class="thead">
                    <th>Специальность</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="spec" items="${specialties}">
                    <tr class="tbody"> 
                        <td><c:out value="${spec.title}"/></td>
                        <td>
                            <a href="./specialties/edit?id=<c:out value="${spec.id}" />">
                                <i title="Редактировать" class="icon-edit"></i>
                            </a>
                        </td>
                        <td>
                            <a onclick="return confirm('Вы действительно хотите удалить специальность?')" href="./specialties/remove?id=<c:out value="${spec.id}" />">
                                <i title="Удалить" class="icon-remove"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <div class="offset1 span11">
            <a class="offset4 btn btn-primary" href="./specialties/add" >
                <i class="icon-plus icon-white"></i> Добавить специальность
            </a>
        </div>

    </body>
</html>
