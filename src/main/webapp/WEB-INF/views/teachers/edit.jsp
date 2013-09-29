<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<%@page contentType="text/html" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <emds:style/>
        <title><emds:title title="${teacher.lastName ? teacher.lastName + '' + teacher.firstName + '' + teacher.middleName  : 'Новый преподаватель'}"/></title>
    </head>
    <body>
        <emds:header/>
        <emds:teacherMenu number="6"/>
        <spring:hasBindErrors name="teacher">
            <emds:error message="Информация о преподавателе не сохранена. Проверьте правильность заполнения формы."/>
        </spring:hasBindErrors>
        <div class="well center-div span5">

            <h3 class="center"><emds:icon icon="111"/> ${teacher.lastName ? teacher.lastName + '' + teacher.firstName + '' + teacher.middleName  : 'Новый преподаватель'}</h3>

            <spring:url var="editTeacher" value="/teachers/edit"/>

            <form:form cssClass="form-horizontal" method="post" action="${editTeacher}" modelAttribute="teacher">
                <form:hidden path="id"/>

                <spring:bind path="lastName">
                    <div id="lastNameDiv" class="control-group${status.error ? ' error' : ''}">
                        <form:label path="lastName" cssClass="control-label">Фамилия:</form:label>
                            <div class="controls">
                            <form:input path="lastName"/>
                            <span class="help-inline"><form:errors path="lastName"/></span>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="firstName">
                    <div id="firstNameDiv" class="control-group${status.error ? ' error' : ''}">
                        <form:label path="firstName" cssClass="control-label">Имя:</form:label>
                            <div class="controls">
                            <form:input path="firstName"/>
                            <span class="help-inline"><form:errors path="firstName"/></span>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="middleName">
                    <div id="middleNameDiv" class="control-group${status.error ? ' error' : ''}">
                        <form:label path="middleName" cssClass="control-label">Отчество:</form:label>
                            <div class="controls">
                            <form:input path="middleName"/>
                            <span class="help-inline"><form:errors path="middleName"/></span>
                        </div>
                    </div>
                </spring:bind>

                <div id="specDiv" class="control-group">
                    <label class="control-label" for="rank">Воинское звание:</label>

                    <div class="controls">
                        <select name="rank" id="rank">
                            <option value="Лейтенант" <c:if test="${teacher.rank eq 'Лейтенант'}">selected</c:if>>Лейтенант
                                </option>
                                <option value="Ст. лейтенант" <c:if test="${teacher.rank eq 'Ст. Лейтенант'}">selected</c:if>>
                                    Ст. лейтенант
                                </option>
                                <option value="Капитан" <c:if test="${teacher.rank eq 'Капитан'}">selected</c:if>>Капитан</option>
                            <option value="Майор" <c:if test="${teacher.rank eq 'Майор'}">selected</c:if>>Майор</option>
                            <option value="Подполковник" <c:if test="${teacher.rank eq 'Подполковник'}">selected</c:if>>
                                    Подполковник
                                </option>
                                <option value="Полковник" <c:if test="${teacher.rank eq 'Полковник'}">selected</c:if>>Полковник
                                </option>
                            </select>
                        </div>
                    </div>

                    <div class="center">
                        <input class="btn btn-primary" type="submit" value="Сохранить"/>
                    <spring:url var="teachers" value="/teachers"/>
                    <a class="btn" href="${teachers}"> Назад </a>
                </div>
            </form:form>

        </div>
    </body>
</html>
