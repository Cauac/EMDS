<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <emds:style/>
        <title><emds:title title="Новый поступающий"/></title>
    </head>
    <body>
        <emds:header/>
        <emds:teacherMenu number="2"/>
        <spring:url value="/abiturients/doAdd" var="addAbiturient"/>
        <spring:url value="/abiturients" var="abiturients"/>
        <spring:hasBindErrors name="student">
            <emds:error message="Информация о студенте не сохранена. Проверьте правильность заполнения формы."/>
        </spring:hasBindErrors>

        <div class="well span5 center-div">

            <h3 class="center"><emds:icon icon="47"/> Новый поступающий</h3>

            <form:form cssClass="form-horizontal" method="post" action="${addAbiturient}" modelAttribute="student">

                <spring:bind path="lastName">
                    <div id="lnameDiv" class="control-group${status.error ? ' error' : ''}">
                        <form:label path="lastName" cssClass="control-label">Фамилия:</form:label>
                            <div class="controls">
                            <form:input path="lastName"/>
                            <span class="help-inline"><form:errors path="lastName"/></span>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="firstName">
                    <div id="nameDiv" class="control-group${status.error ? ' error' : ''}">
                        <form:label path="firstName" cssClass="control-label">Имя:</form:label>
                            <div class="controls">
                            <form:input path="firstName"/>
                            <span class="help-inline"><form:errors path="firstName"/></span>
                        </div>
                    </div>
                </spring:bind>                

                <spring:bind path="middleName">
                    <div id="mnameDiv" class="control-group${status.error ? ' error' : ''}">
                        <form:label path="middleName" cssClass="control-label">Отчество:</form:label>
                            <div class="controls">
                            <form:input path="middleName"/>
                            <span class="help-inline"><form:errors path="middleName"/></span>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="questionnaire.faculty">
                    <div id="facultyDiv" class="control-group">
                        <form:label path="questionnaire.faculty" cssClass="control-label">Факультет:</form:label>
                            <div class="controls">
                            <form:select path="questionnaire.faculty">
                                <form:options items="${faculties}"/>
                            </form:select>
                        </div>
                    </div>
                </spring:bind>

                <div class="center">
                    <button class="btn" type="submit"> <emds:icon icon="7" text="Сохранить"/> Сохранить </button>
                    <a class="btn btn-info" href="${abiturients}"> Назад </a>
                </div>

            </form:form>

        </div>
    </body>
</html>
