<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="utf-8" %>
<%--todo: complete student edition--%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <emds:style/>
    <title><emds:title title="Редактировать студента"/></title>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="1"/>
<%--<div class="well offset4 span5">

<h3 class="center"><c:out value="${student.lastName}"/> <c:out value="${student.firstName}"/> <c:out
        value="${student.middleName}"/></h3>--%>

<spring:url var="editStudent" value="/students/edit"/>
<form:form cssClass="form-horizontal" method="post" action="${editStudent}" modelAttribute="student">

<form:hidden path="id"/>
<div class="well center-div span11">

<div style="clear:both;"></div>
<h3 class="center"><c:out value="${student.lastName}"/> <c:out value="${student.firstName}"/></h3>
<br>

<div class="span5">

    <spring:bind path="student.lastName">
        <div id="lastNameDiv" class="control-group${(not empty status.errorMessage) ? ' error':''}">
            <form:label path="lastName" cssClass="control-label">Фамилия:</form:label>
            <div class="controls">
                <form:input path="lastName"/>
                <span class="help-inline"><form:errors path="lastName"/></span>
            </div>
        </div>
    </spring:bind>

    <spring:bind path="student.firstName">
        <div id="firstNameDiv" class="control-group${(not empty status.errorMessage) ? ' error':''}">
            <form:label path="firstName" cssClass="control-label">Имя:</form:label>
            <div class="controls">
                <form:input path="firstName"/>
                <span class="help-inline"><form:errors path="firstName"/></span>
            </div>
        </div>
    </spring:bind>

    <spring:bind path="student.middleName">
        <div id="middleNameDiv" class="control-group${(not empty status.errorMessage) ? ' error':''}">
            <form:label path="middleName" cssClass="control-label">Отчество:</form:label>
            <div class="controls">
                <form:input path="middleName"/>
                <span class="help-inline"><form:errors path="middleName"/></span>
            </div>
        </div>
    </spring:bind>


    <spring:bind path="student.birthDate">
        <div id="dobDiv" class="control-group${(not empty status.errorMessage) ? ' error':''}">
            <form:label path="birthDate" cssClass="control-label">Дата рождения:</form:label>
            <div class="controls">
                <form:input placeholder="ДД.ММ.ГГГГ" path="birthDate" cssErrorClass="error"/>
                <span class="help-inline"><form:errors path="birthDate"/></span>
            </div>
        </div>
    </spring:bind>

    <spring:bind path="student.questionnaire.nationality">
        <div id="nationalityDiv" class="control-group${(not empty status.errorMessage) ? ' error':''}">
            <form:label path="questionnaire.nationality" cssClass="control-label">Национальность:</form:label>
            <div class="controls">
                <form:input path="questionnaire.nationality"/>
                <span class="help-inline"><form:errors path="questionnaire.nationality"/></span>
            </div>
        </div>
    </spring:bind>

    <spring:bind path="student.questionnaire.birthPlace">
        <div id="placeOBDiv" class="control-group${(not empty status.errorMessage) ? ' error':''}">
            <form:label path="questionnaire.birthPlace" cssClass="control-label">Место рождения:</form:label>
            <div class="controls">
                <form:input path="questionnaire.birthPlace"/>
                <span class="help-inline"><form:errors path="questionnaire.birthPlace"/></span>
            </div>
        </div>
    </spring:bind>

    <div id="familyDiv" class="control-group">
        <form:label path="questionnaire.familyStatus" cssClass="control-label">Семейное положение:</form:label>
        <div class="controls">
            <form:input path="questionnaire.familyStatus"/>
            <span class="help-inline"><form:errors path="questionnaire.familyStatus"/></span>
        </div>
    </div>

    <div id="passportNumberDiv" class="control-group">
        <form:label path="questionnaire.passportNumber" cssClass="control-label">Номер паспорта:</form:label>
        <div class="controls">
            <form:input path="questionnaire.passportNumber"/>
            <span class="help-inline"><form:errors path="questionnaire.passportNumber"/></span>
        </div>
    </div>

    <div id="personalNumberDiv" class="control-group">
        <form:label path="questionnaire.personalNumber" cssClass="control-label">Личный номер:</form:label>
        <div class="controls">
            <form:input path="questionnaire.personalNumber"/>
            <span class="help-inline"><form:errors path="questionnaire.personalNumber"/></span>
        </div>
    </div>

    <div id="mobileNumberDiv" class="control-group">
        <form:label path="questionnaire.mobileTel" cssClass="control-label">Мобильный телефон:</form:label>
        <div class="controls">
            <form:input path="questionnaire.mobileTel"/>
            <span class="help-inline"><form:errors path="questionnaire.mobileTel"/></span>
        </div>
    </div>

    <div id="homeNumberDiv" class="control-group">
        <form:label path="questionnaire.homeTel" cssClass="control-label">Домашний телефон:</form:label>
        <div class="controls">
            <form:input path="questionnaire.homeTel"/>
            <span class="help-inline"><form:errors path="questionnaire.homeTel"/></span>
        </div>
    </div>
</div>

<div class="span5">

    <h5>Адрес</h5>

    <div id="selfAddressDiv" class="control-group">
        <div>
            <form:input path="questionnaire.address.city" placeholder="Город" cssClass="input input-small"/>
            <form:input path="questionnaire.address.street" placeholder="Улица" cssClass="input input-medium"/>
            д. <form:input path="questionnaire.address.house" cssClass="input input-mini"/>
            кв. <form:input path="questionnaire.address.apartment" cssClass="input input-mini"/>
        </div>
    </div>

    <h5>Адрес родителей</h5>

    <div id="parentsAddressDiv" class="control-group">
        <div>
            <form:input path="questionnaire.parentAddress.city" placeholder="Город"
                        cssClass="input input-small"/>
            <form:input path="questionnaire.parentAddress.street" placeholder="Улица"
                        cssClass="input input-medium"/>
            д. <form:input path="questionnaire.parentAddress.house" cssClass="input input-mini"/>
            кв. <form:input path="questionnaire.parentAddress.apartment" cssClass="input input-mini"/>
        </div>
    </div>

    <div id="motherDiv" class="control-group">
        <form:label path="questionnaire.mother">Мать (ФИО, место работы, должность):</form:label>
        <div>
            <form:input path="questionnaire.mother" cssClass="span5"/>
        </div>
    </div>
    <div id="fatherDiv" class="control-group">
        <form:label path="questionnaire.father">Отец (ФИО, место работы, должность):</form:label>
        <div>
            <form:input path="questionnaire.father" cssClass="span5"/>
        </div>
    </div>
    <div id="parentsPhonesDiv" class="control-group">
        <form:label path="questionnaire.parentTel">Телефоны близких родственников:</form:label>
        <div>
            <form:input path="questionnaire.parentTel" cssClass="span5"/>
        </div>
    </div>
</div>

<div style="clear:both;"></div>
<h4 class="center">Обучение в университете </h4>
<br>

<div class="span5">

    <div id="facultyDiv" class="control-group">
        <form:label path="questionnaire.faculty" cssClass="control-label">Факультет:</form:label>
        <div class="controls">
            <form:input path="questionnaire.faculty"/>
            <span class="help-inline"><form:errors path="questionnaire.faculty"/></span>
        </div>
    </div>

    <div id="admissionYearDiv" class="control-group">
        <form:label path="questionnaire.admissionYear" cssClass="control-label">Год поступления:</form:label>
        <div class="controls">
            <form:input path="questionnaire.admissionYear"/>
            <span class="help-inline"><form:errors path="questionnaire.admissionYear"/></span>
        </div>
    </div>

    <div id="courseDiv" class="control-group">
        <form:label path="questionnaire.course" cssClass="control-label">Курс:</form:label>
        <div class="controls">
            <form:input path="questionnaire.course"/>
            <span class="help-inline"><form:errors path="questionnaire.course"/></span>
        </div>
    </div>

    <div id="groupDiv" class="control-group">
        <form:label path="questionnaire.studyGroup2" cssClass="control-label">Учебная группа:</form:label>
        <div class="controls">
            <form:input path="questionnaire.studyGroup2"/>
            <span class="help-inline"><form:errors path="questionnaire.studyGroup2"/></span>
        </div>
    </div>

    <div id="specialityDiv" class="control-group">
        <form:label path="questionnaire.studySpecialty" cssClass="control-label">Специальность:</form:label>
        <div class="controls">
            <form:input path="questionnaire.studySpecialty"/>
            <span class="help-inline"><form:errors path="questionnaire.studySpecialty"/></span>
        </div>
    </div>

    <div id="progressDiv" class="control-group">
        <form:label path="questionnaire.studyProgress" cssClass="control-label">Успеваемость:</form:label>
        <div class="controls">
            <form:input path="questionnaire.studyProgress"/>
            <span class="help-inline"><form:errors path="questionnaire.studyProgress"/></span>
        </div>
    </div>

    <div id="educationTypeDiv" class="control-group">
        <form:label path="questionnaire.educationType" cssClass="control-label">Вид обучения:</form:label>
        <div class="controls">
            <form:select path="questionnaire.educationType">
                <form:option value="Бюджетное"/>
                <form:option value="Платное"/>
            </form:select>
            <span class="help-inline"><form:errors path="questionnaire.educationType"/></span>
        </div>
    </div>

</div>

<div class="span5">

    <div id="curatorDiv" class="control-group">
        <form:label path="questionnaire.curator">Куратор:</form:label>
        <div>
            <form:input path="questionnaire.curator" cssClass="span5"/>
        </div>
    </div>

    <div id="curatorTelDiv" class="control-group">
        <form:label path="questionnaire.curatorTel">Телефон куратора:</form:label>
        <div>
            <form:input path="questionnaire.curatorTel" cssClass="span5"/>
        </div>
    </div>

    <div id="beforeEducationDiv" class="control-group">
        <form:label path="questionnaire.educationBefore">Образование до университета:</form:label>
        <div>
            <form:input path="questionnaire.educationBefore" cssClass="span5"/>
        </div>
    </div>

    <div id="facultyPublicLifeDiv" class="control-group">
        <form:label path="questionnaire.facultyPublicLife">Участие в общественной жизни университета:</form:label>
        <div>
            <form:input path="questionnaire.facultyPublicLife" cssClass="span5"/>
        </div>
    </div>


</div>

<div style="clear:both;"></div>
<h4 class="center">Общая информация</h4>
<br>

<div class="span5">

    <div id="hobbyDiv" class="control-group">
        <form:label path="questionnaire.hobby">Увлечения:</form:label>
        <div>
            <form:textarea path="questionnaire.hobby" cssClass="span5" rows="4"/>
        </div>
    </div>

    <div id="publicOrganizationDiv" class="control-group">
        <form:label path="questionnaire.publicOrganization">Общественные организации:</form:label>
        <div>
            <form:textarea path="questionnaire.publicOrganization" cssClass="span5" rows="4"/>
        </div>
    </div>

    <div id="employmentDiv" class="control-group">
        <form:label path="questionnaire.employment">Работа:</form:label>
        <div>
            <form:textarea path="questionnaire.employment" cssClass="span5" rows="4"/>
        </div>
    </div>

</div>


<div class="span5">

    <div id="informationDiv" class="control-group">
        <form:label path="questionnaire.howDidYouHearAbout">Источники информации о военной кафедре:</form:label>
        <div>
            <form:textarea path="questionnaire.howDidYouHearAbout" cssClass="span5" rows="2"/>
        </div>
    </div>

    <div id="continueDiv" class="control-group">
        <form:label
                path="questionnaire.desireToContinue">Планирует ли продолжить обучение по программе офицеров запаса:</form:label>
        <div>
            <form:textarea path="questionnaire.desireToContinue" cssClass="span5" rows="2"/>
        </div>
    </div>

    <div id="thinkAboutStudyDiv" class="control-group">
        <form:label path="questionnaire.thinkAboutStudy">Отношение к приобретаемой военной специльности:</form:label>
        <div>
            <form:textarea path="questionnaire.thinkAboutStudy" cssClass="span5" rows="2"/>
        </div>
    </div>

    <div id="thinkAboutDutyDiv" class="control-group">
        <form:label path="questionnaire.thinkAboutDuty">Отношение к службе в армии:</form:label>
        <div>
            <form:textarea path="questionnaire.thinkAboutDuty" cssClass="span5" rows="2"/>
        </div>
    </div>

    <div id="dutyDiv" class="control-group">
        <form:label path="questionnaire.duty">Служба в армии:</form:label>
        <div>
            <form:textarea path="questionnaire.duty" cssClass="span5" rows="2"/>
        </div>
    </div>

</div>


</div>

<div style="clear: both" class="center">
    <input class="btn btn-primary" type="submit" value="Сохранить"/>
    <spring:url var="students" value="/students"/>
    <a class="btn" href="${students}"> Назад </a>
</div>

</form:form>

<%--</div>   --%>
</body>
</html>
