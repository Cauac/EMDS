<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <emds:style/>
        <title><emds:title title="Анкета"/></title>
    </head>
    <body>
        <emds:header/>
        <emds:teacherMenu number="2"/>
        <spring:hasBindErrors name="student">
            <emds:error message="Анкета не сохранена. Проверьте правильность заполнения формы."/>
        </spring:hasBindErrors>

        <spring:url value="/documents/questionnaire" var="documentURL"/>

        <form:form action="${documentURL}" method="post" cssClass="form-horizontal" modelAttribute="student">

            <form:hidden path="id"/>
            <div class="well center-div span11">

                <div style="clear:both;"></div>
                <h3 class="center"><c:out value="${student.lastName}"/> <c:out value="${student.firstName}"/></h3>
                <br>

                <div class="span5">

                    <spring:bind path="birthDate">
                        <div id="dobDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="birthDate" cssClass="control-label">Дата рождения:</form:label>
                                <div class="controls">
                                <form:input placeholder="ДД.ММ.ГГГГ" path="birthDate" cssErrorClass="error"/>
                                <span class="help-inline"><form:errors path="birthDate"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.nationality">
                        <div id="nationalityDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.nationality" cssClass="control-label">Национальность:</form:label>
                                <div class="controls">
                                <form:input path="questionnaire.nationality"/>
                                <span class="help-inline"><form:errors path="questionnaire.nationality"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.birthPlace">
                        <div id="placeOBDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.birthPlace" cssClass="control-label">Место рождения:</form:label>
                                <div class="controls">
                                <form:input path="questionnaire.birthPlace"/>
                                <span class="help-inline"><form:errors path="questionnaire.birthPlace"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.familyStatus">
                        <div id="familyDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.familyStatus" cssClass="control-label">Семейное положение:</form:label>
                                <div class="controls">
                                <form:input path="questionnaire.familyStatus"/>
                                <span class="help-inline"><form:errors path="questionnaire.familyStatus"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.passportNumber">
                        <div id="passportNumberDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.passportNumber" cssClass="control-label">Номер паспорта:</form:label>
                                <div class="controls">
                                <form:input path="questionnaire.passportNumber"/>
                                <span class="help-inline"><form:errors path="questionnaire.passportNumber"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.personalNumber">
                        <div id="personalNumberDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.personalNumber" cssClass="control-label">Личный номер:</form:label>
                                <div class="controls">
                                <form:input path="questionnaire.personalNumber"/>
                                <span class="help-inline"><form:errors path="questionnaire.personalNumber"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.mobileTel">
                        <div id="mobileNumberDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.mobileTel" cssClass="control-label">Мобильный телефон:</form:label>
                                <div class="controls">
                                <form:input path="questionnaire.mobileTel"/>
                                <span class="help-inline"><form:errors path="questionnaire.mobileTel"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.homeTel">
                        <div id="homeNumberDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.homeTel" cssClass="control-label">Домашний телефон:</form:label>
                                <div class="controls">
                                <form:input path="questionnaire.homeTel"/>
                                <span class="help-inline"><form:errors path="questionnaire.homeTel"/></span>
                            </div>
                        </div>
                    </spring:bind>
                </div>

                <div class="span5">

                    <h5>Адрес</h5>


                    <div id="selfAddressDiv" class="control-group">
                        <div>
                            <spring:bind path="questionnaire.address.city">
                                <form:input path="questionnaire.address.city" placeholder="Город"
                                            cssClass="input input-small" cssStyle="${status.error ? ' border-color:red' : ''}"/>
                            </spring:bind>
                            <spring:bind path="questionnaire.address.street">
                                <form:input path="questionnaire.address.street" placeholder="Улица" 
                                            cssClass="input input-medium" cssStyle="${status.error ? ' border-color:red' : ''}"/>
                            </spring:bind>
                            <spring:bind path="questionnaire.address.house">
                                д. <form:input path="questionnaire.address.house" cssClass="input input-mini"
                                            cssStyle="${status.error ? ' border-color:red' : ''}"/>
                            </spring:bind>
                            <spring:bind path="questionnaire.address.apartment">
                                кв. <form:input path="questionnaire.address.apartment" cssClass="input input-mini"
                                            cssStyle="${status.error ? ' border-color:red' : ''}"/>
                            </spring:bind>
                        </div>
                    </div>

                    <h5>Адрес родителей</h5>

                    <div id="parentsAddressDiv" class="control-group">
                        <div>
                            <spring:bind path="questionnaire.parentAddress.city">
                                <form:input path="questionnaire.parentAddress.city" placeholder="Город"
                                            cssClass="input input-small" cssStyle="${status.error ? ' border-color:red' : ''}"/>
                            </spring:bind>
                            <spring:bind path="questionnaire.parentAddress.street">
                                <form:input path="questionnaire.parentAddress.street" placeholder="Улица" 
                                            cssClass="input input-medium" cssStyle="${status.error ? ' border-color:red' : ''}"/>
                            </spring:bind>
                            <spring:bind path="questionnaire.parentAddress.house">
                                д. <form:input path="questionnaire.parentAddress.house" cssClass="input input-mini"
                                            cssStyle="${status.error ? ' border-color:red' : ''}"/>
                            </spring:bind>
                            <spring:bind path="questionnaire.parentAddress.apartment">
                                кв. <form:input path="questionnaire.parentAddress.apartment" cssClass="input input-mini"
                                            cssStyle="${status.error ? ' border-color:red' : ''}"/>
                            </spring:bind>
                        </div>
                    </div>

                    <spring:bind path="questionnaire.mother">
                        <div id="motherDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.mother">Мать (ФИО, место работы, должность):</form:label>
                                <div>
                                <form:input path="questionnaire.mother" cssClass="span5"/>
                                <span class="help-inline"><form:errors path="questionnaire.mother"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.father">
                        <div id="fatherDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.father">Отец (ФИО, место работы, должность):</form:label>
                                <div>
                                <form:input path="questionnaire.father" cssClass="span5"/>
                                <span class="help-inline"><form:errors path="questionnaire.father"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.parentTel">
                        <div id="parentsPhonesDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.parentTel">Телефоны близких родственников:</form:label>
                                <div>
                                <form:input path="questionnaire.parentTel" cssClass="span5"/>
                                <span class="help-inline"><form:errors path="questionnaire.parentTel"/></span>
                            </div>
                        </div>
                    </spring:bind>

                </div>

                <div style="clear:both;"></div>
                <h4 class="center">Обучение в университете </h4>
                <br>

                <div class="span5">

                    <spring:bind path="questionnaire.admissionYear">
                        <div id="admissionYearDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.admissionYear" cssClass="control-label">Год поступления:</form:label>
                                <div class="controls">
                                <form:input path="questionnaire.admissionYear"/>
                                <span class="help-inline"><form:errors path="questionnaire.admissionYear"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.course">
                        <div id="courseDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.course" cssClass="control-label">Курс:</form:label>
                                <div class="controls">
                                <form:input path="questionnaire.course"/>
                                <span class="help-inline"><form:errors path="questionnaire.course"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.studyGroup2">
                        <div id="groupDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.studyGroup2" cssClass="control-label">Учебная группа:</form:label>
                                <div class="controls">
                                <form:input path="questionnaire.studyGroup2"/>
                                <span class="help-inline"><form:errors path="questionnaire.studyGroup2"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.studySpecialty">
                        <div id="specialityDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.studySpecialty" cssClass="control-label">Специальность:</form:label>
                                <div class="controls">
                                <form:input path="questionnaire.studySpecialty"/>
                                <span class="help-inline"><form:errors path="questionnaire.studySpecialty"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.studyProgress">
                        <div id="progressDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.studyProgress" cssClass="control-label">Успеваемость:</form:label>
                                <div class="controls">
                                <form:input path="questionnaire.studyProgress"/>
                                <span class="help-inline"><form:errors path="questionnaire.studyProgress"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.educationType">
                        <div id="educationTypeDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.educationType" cssClass="control-label">Вид обучения:</form:label>
                                <div class="controls">
                                <form:select path="questionnaire.educationType">
                                    <form:option value="Бюджетное"/>
                                    <form:option value="Платное"/>
                                </form:select>
                                <span class="help-inline"><form:errors path="questionnaire.educationType"/></span>
                            </div>
                        </div>
                    </spring:bind>

                </div>

                <div class="span5">

                    <spring:bind path="questionnaire.curator">
                        <div id="curatorDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.curator">Куратор:</form:label>
                                <div>
                                <form:input path="questionnaire.curator" cssClass="span5"/>
                                <span class="help-inline"><form:errors path="questionnaire.curator"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.curatorTel">
                        <div id="curatorTelDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.curatorTel">Телефон куратора:</form:label>
                                <div>
                                <form:input path="questionnaire.curatorTel" cssClass="span5"/>
                                <span class="help-inline"><form:errors path="questionnaire.curatorTel"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.educationBefore">
                        <div id="beforeEducationDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.educationBefore">Образование до университета:</form:label>
                                <div>
                                <form:input path="questionnaire.educationBefore" cssClass="span5"/>
                                <span class="help-inline"><form:errors path="questionnaire.educationBefore"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.facultyPublicLife">
                        <div id="facultyPublicLifeDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.facultyPublicLife">Участие в общественной жизни университета:</form:label>
                                <div>
                                <form:input path="questionnaire.facultyPublicLife" cssClass="span5"/>
                                <span class="help-inline"><form:errors path="questionnaire.facultyPublicLife"/></span>
                            </div>
                        </div>
                    </spring:bind>

                </div>

                <div style="clear:both;"></div>
                <h4 class="center">Общая информация</h4>
                <br>

                <div class="span5">

                    <spring:bind path="questionnaire.hobby">
                        <div id="hobbyDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.hobby">Увлечения:</form:label>
                                <div>
                                <form:textarea path="questionnaire.hobby" cssClass="span5" rows="2"/>
                                <span class="help-inline"><form:errors path="questionnaire.hobby"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.publicOrganization">
                        <div id="publicOrganizationDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.publicOrganization">Общественные организации:</form:label>
                                <div>
                                <form:textarea path="questionnaire.publicOrganization" cssClass="span5" rows="2"/>
                                <span class="help-inline"><form:errors path="questionnaire.publicOrganization"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.employment">
                        <div id="employmentDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.employment">Работа:</form:label>
                                <div>
                                <form:textarea path="questionnaire.employment" cssClass="span5" rows="2"/>
                                <span class="help-inline"><form:errors path="questionnaire.employment"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.howDidYouHearAbout">
                        <div id="informationDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.howDidYouHearAbout">Источники информации о военной кафедре:</form:label>
                                <div>
                                <form:textarea path="questionnaire.howDidYouHearAbout" cssClass="span5" rows="2"/>
                                <span class="help-inline"><form:errors path="questionnaire.howDidYouHearAbout"/></span>
                            </div>
                        </div>
                    </spring:bind>

                </div>


                <div class="span5">

                    <spring:bind path="questionnaire.desireToContinue">
                        <div id="continueDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label
                                path="questionnaire.desireToContinue">Планирует ли продолжить обучение по программе офицеров запаса:</form:label>
                                <div>
                                <form:textarea path="questionnaire.desireToContinue" cssClass="span5" rows="2"/>
                                <span class="help-inline"><form:errors path="questionnaire.desireToContinue"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.thinkAboutStudy">
                        <div id="thinkAboutStudyDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.thinkAboutStudy">Отношение к приобретаемой военной специльности:</form:label>
                                <div>
                                <form:textarea path="questionnaire.thinkAboutStudy" cssClass="span5" rows="2"/>
                                <span class="help-inline"><form:errors path="questionnaire.thinkAboutStudy"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.thinkAboutDuty">
                        <div id="thinkAboutDutyDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.thinkAboutDuty">Отношение к службе в армии:</form:label>
                                <div>
                                <form:textarea path="questionnaire.thinkAboutDuty" cssClass="span5" rows="2"/>
                                <span class="help-inline"><form:errors path="questionnaire.thinkAboutDuty"/></span>
                            </div>
                        </div>
                    </spring:bind>

                    <spring:bind path="questionnaire.duty">
                        <div id="dutyDiv" class="control-group${status.error ? ' error' : ''}">
                            <form:label path="questionnaire.duty">Служба в армии:</form:label>
                                <div>
                                <form:textarea path="questionnaire.duty" cssClass="span5" rows="2"/>
                                <span class="help-inline"><form:errors path="questionnaire.duty"/></span>
                            </div>
                        </div>
                    </spring:bind>

                </div>

                <input type="hidden" id="commentary" name="commentary" value="${currentDate}"/>

                <div style="clear: both" class="center">
                    <input class="btn btn-primary" type="submit" value="Сохранить информацию"/>
                    <spring:url var="abiturients" value="/abiturients"/>
                    <a class="btn" href="${abiturients}"> Отмена </a>
                </div>

                <div style="clear:both;"></div>

            </div>

        </form:form>

    </body>
</html>