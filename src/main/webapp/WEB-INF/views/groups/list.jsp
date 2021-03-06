<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <emds:style/>
        <title><emds:title title="Группы"/></title>
    </head>
    <body>
        <emds:header/>
        <emds:teacherMenu number="5"/>
        <emds:win-fail/>
        <br>
        <c:if test="${fn:length(groups) gt 0}">
            <table class="table table-condensed center-div span7">
                <tr class="thead">
                    <th>Группа</th>
                    <th>Специальность</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="group" items="${groups}">
                    <tr class="tbody">
                        <td><c:out value="${group.title}"/></td>
                        <td><c:out value="ВУС ${group.specialty.number}"/></td>
                        <td>
                            <spring:url var="editGroup" value="/groups/edit">
                                <spring:param name="id" value="${group.id}"/>
                            </spring:url>
                            <a href="${editGroup}"> <emds:icon icon="13" text="Редактировать" /> </a>
                        </td>
                        <td>
                            <spring:url var="removeGroup" value="/groups/remove">
                                <spring:param name="id" value="${group.id}"/>
                            </spring:url>
                            <a onclick="return confirm('Вы действительно хотите удалить группу?')"
                               href="${removeGroup}">
                                <emds:icon icon="118" text="Удалить" /> </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <br>
        <div class="center">
            <spring:url var="addGroup" value="/groups/edit"/>
            <a style="width: 180px" class="btn" href="${addGroup}">
                <emds:icon icon="112" text="Добавить группу" /> Добавить группу
            </a>
        </div>

    </body>
</html>
