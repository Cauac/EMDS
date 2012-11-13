<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <mytags:style/>
        <title>ВК ВГУ :: <c:out value="${group.title}"/></title>
    </head>
    <body>
        <mytags:header />
        <mytags:teacherMenu number="5"/>
        <div class="well offset4 span5">

            <h3 class="center">Редактировать группу</h3>

            <form class="form-horizontal" method="post" action="../groups/edit">

                <input type="hidden" name="id" value="<c:out value="${group.id}"/>">
                
                <div id="nameDiv" class="control-group">
                    <label class="control-label" for="title">Название:</label>
                    <div class="controls">
                        <input class="input" type="text" id="title" name="title" value="<c:out value="${group.title}"/>">
                        <span class="help-inline" ></span>
                    </div>
                </div>

                <div id="specDiv" class="control-group">
                    <label class="control-label" for="specId">Специальность:</label>
                    <div class="controls">
                        <select name="specId">
                            <c:forEach var="spec" items="${specialties}">
                                <option value="${spec.id}" <c:if test="${spec.id eq group.specialty.id}">selected</c:if>>${spec.title}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="center">
                    <input class="btn btn-primary" type="submit" value="Сохранить"/>
                    <a class="btn" href="../groups"> Назад </a>
                </div>
            </form>

        </div>
    </body>
</html>
