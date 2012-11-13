<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <mytags:style/>
        <title>ВК ВГУ :: Группы</title>
    </head>
    <body>
        <mytags:header/>
        <mytags:teacherMenu number="5" />
        <br>

        <c:if test="${fn:length(groups) gt 0}">
            <table class="table table-condensed offset2 span9">
                <tr class="thead">
                    <th>Группа</th>
                    <th>Специальность</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="group" items="${groups}">
                    <tr class="tbody">
                        <td><c:out value="${group.title}"/></td>
                        <td><c:out value="${group.specialty.title}"/></td>
                        <td> 
                            <a href="./groups/edit?id=<c:out value="${group.id}" />">
                                <i title="Редактировать группу" class="icon-edit"></i> </a>
                        </td>
                        <td> <a onclick="return confirm('Вы действительно хотите удалить группу?')" href="./groups/remove?id=<c:out value="${group.id}" />">
                                <i title="Удалить группу" class="icon-remove"></i> </a> 
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <div class="offset1 span11">
            <a style="width: 180px" class="offset4 btn btn-primary" href="./groups/add" >
                <i class="icon-plus icon-white"></i> Добавить группу
            </a>
        </div>

    </body>
</html>
