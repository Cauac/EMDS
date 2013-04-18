<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<%@page contentType="text/html" pageEncoding="utf-8" %>
<!DOCTYPE html>
<%-- todo:complete student addition ? --%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <mytags:style/>
    <title>ВК ВГУ :: Добавить студента</title>
</head>
<body>
<mytags:header/>
<mytags:teacherMenu number="1"/>

<div style="clear:both;"></div>

<spring:url var="addStudent" value="/teacher/students/add"/>
<form class="form-horizontal" method="post" action="${addStudent}">

    <div class="well offset1 span11">

        <div class="span5">

            <h3 class="center">Основная информация</h3>

            <div id="lNameDiv" class="control-group">
                <label class="control-label" for="lastName">Фамилия:</label>

                <div class="controls">
                    <input class="input" type="text" id="lastName" name="lastName">
                    <span class="help-inline"></span>
                </div>
            </div>

            <div id="nameDiv" class="control-group">
                <label class="control-label" for="firstName">Имя:</label>

                <div class="controls">
                    <input class="input" type="text" id="firstName" name="firstName">
                    <span class="help-inline"></span>
                </div>
            </div>

            <div id="mNameDiv" class="control-group">
                <label class="control-label" for="middleName">Отчество:</label>

                <div class="controls">
                    <input class="input" type="text" id="middleName" name="middleName">
                    <span class="help-inline"></span>
                </div>
            </div>

            <div id="dobDiv" class="control-group">
                <label class="control-label" for="dateOfBirth">Дата рождения:</label>

                <div class="controls">
                    <input class="input" type="text" id="dateOfBirth" name="dateOfBirth" placeholder="дд.мм.гггг">
                    <span class="help-inline"></span>
                </div>
            </div>

            <div id="groupDiv" class="control-group">
                <label class="control-label" for="group">Группа:</label>

                <div class="controls">
                    <select name="group" id="group">
                        <c:forEach var="gr" items="${groups}">
                            <option value="${gr.id}">${gr.title}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div id="characteristicDiv" class="control-group">
                <label class="control-label" for="characteristic">Характеристика:</label>

                <div class="controls">
                    <textarea class="input" maxlength="10000" id="characteristic" name="characteristic">
                    </textarea>
                    <span class="help-inline"></span>
                </div>
            </div>

            <div id="rankDiv" class="control-group">
                <label class="control-label" for="rank">Звание:</label>

                <div class="controls">
                    <input class="input" type="text" id="rank" name="rank">
                    <span class="help-inline"></span>
                </div>
            </div>
        </div>


        <div class="span5">

            <h3 class="center">Анкетные данные</h3>

            <div id="placeOBDiv" class="control-group">
                <label class="control-label" for="birthPlace">Место рождения:</label>

                <div class="controls">
                    <input class="input" type="text" id="birthPlace" name="birthPlace">
                    <span class="help-inline"></span>
                </div>
            </div>

            <div id="nationalityDiv" class="control-group">
                <label class="control-label" for="nationality">Национальность:</label>

                <div class="controls">
                    <input class="input" type="text" id="nationality" name="nationality">
                    <span class="help-inline"></span>
                </div>
            </div>

            <div id="passportNumberDiv" class="control-group">
                <label class="control-label" for="passportNumber">Номер паспорта:</label>

                <div class="controls">
                    <input class="input" type="text" id="passportNumber" name="passportNumber">
                    <span class="help-inline"></span>
                </div>
            </div>

            <div id="mobileTelDiv" class="control-group">
                <label class="control-label" for="mobileTel">Мобильный телефон:</label>

                <div class="controls">
                    <input class="input" type="text" id="mobileTel" name="mobileTel">
                    <span class="help-inline"></span>
                </div>
            </div>

            <div id="homeTelDiv" class="control-group">
                <label class="control-label" for="homeTel">Домашний телефон:</label>

                <div class="controls">
                    <input class="input" type="text" id="homeTel" name="homeTel">
                    <span class="help-inline"></span>
                </div>
            </div>

            <!-- ***************** -->
            <h4 class="center">Адрес</h4>

            <div id="addr1Div" class="control-group">
                <div>
                    <input class="input input-small" type="text" id="city" name="city" placeholder="Город">
                    <input class="input input-medium" type="text" id="street" name="street" placeholder="Улица">
                    д. <input class="input input-mini" type="text" id="house" name="house">
                    кв. <input class="input input-mini" type="text" id="apartment" name="apartment">
                </div>
            </div>


        </div>

    </div>

    <div style="clear: both" class="center">
        <input class="btn btn-primary btn-large" type="submit" value="Добавить студента"/>
    </div>


</form>


</body>
</html>
