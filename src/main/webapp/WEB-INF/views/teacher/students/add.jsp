<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <mytags:style/>
        <title>ВК ВГУ :: Добавить студента</title>
    </head>
    <body>
        <mytags:header />
        <mytags:teacherMenu number="1"/>

        <!--        <div style="clear:both;"></div>
        
                <h2 class="center">Новый студент</h2> 
                <br>-->

        <div style="clear:both;"></div>

        <form class="form-horizontal" method="post" action="../students/add">


            <div class="well offset1 span11">

                <div class="span5">

                    <h3 class="center">Основная информация</h3> 


                    <div id="nameDiv" class="control-group">
                        <label class="control-label" for="lastName">Фамилия:</label>
                        <div class="controls">
                            <input class="input" type="text" id="lastName" name="lastName">
                            <span class="help-inline" ></span>
                        </div>
                    </div>

                    <div id="nameDiv" class="control-group">
                        <label class="control-label" for="firstName">Имя:</label>
                        <div class="controls">
                            <input class="input" type="text" id="firstName" name="firstName">
                            <span class="help-inline" ></span>
                        </div>
                    </div>

                    <div id="nameDiv" class="control-group">
                        <label class="control-label" for="middleName">Отчество:</label>
                        <div class="controls">
                            <input class="input" type="text" id="middleName" name="middleName">
                            <span class="help-inline" ></span>
                        </div>
                    </div>

                    <div id="dobDiv" class="control-group">
                        <label class="control-label" for="dob">Дата рождения:</label>
                        <div class="controls">
                            <input class="input" type="text" id="dob" name="dob" placeholder="дд.мм.гггг">
                            <span class="help-inline" ></span>
                        </div>
                    </div>

                    <div id="groupDiv" class="control-group">
                        <label class="control-label" for="group">Группа:</label>
                        <div class="controls">
                            <select name="group">
                                <c:forEach var="gr" items="${groups}">
                                    <option value="${gr.id}">${gr.title}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>





                <div class="span5">

                    <h3 class="center">Анкетные данные</h3> 

                    <div id="placeOBDiv" class="control-group">
                        <label class="control-label" for="questionnaire.birthPlace">Место рождения:</label>
                        <div class="controls">
                            <input class="input" type="text" id="birthPlace" name="birthPlace">
                            <span class="help-inline" ></span>
                        </div>
                    </div>

                    <div id="nationalityDiv" class="control-group">
                        <label class="control-label" for="nationality">Национальность:</label>
                        <div class="controls">
                            <input class="input" type="text" id="nationality" name="nationality">
                            <span class="help-inline" ></span>
                        </div>
                    </div>

                    <div id="passportNumberDiv" class="control-group">
                        <label class="control-label" for="passportNumber">Номер паспорта:</label>
                        <div class="controls">
                            <input class="input" type="text" id="passportNumber" name="passportNumber">
                            <span class="help-inline" ></span>
                        </div>
                    </div>

                    <div id="mobileTelDiv" class="control-group">
                        <label class="control-label" for="mobileTel">Мобильный телефон:</label>
                        <div class="controls">
                            <input class="input" type="text" id="mobileTel" name="mobileTel">
                            <span class="help-inline" ></span>
                        </div>
                    </div>

                    <div id="homeTelDiv" class="control-group">
                        <label class="control-label" for="homeTel">Домашний телефон:</label>
                        <div class="controls">
                            <input class="input" type="text" id="homeTel" name="homeTel">
                            <span class="help-inline" ></span>
                        </div>
                    </div>

                    <!-- ***************** -->
                    <h4 class="center">Адрес</h4>

                    <div id="addr1Div" class="control-group">
                        <div>
                            <input class="input input-small" type="text" id="city1" name="city1" placeholder="Город">
                            <input class="input input-medium" type="text" id="street1" name="street1" placeholder="Улица">
                           д. <input class="input input-mini" type="text" id="house1" name="house1">
                           кв. <input class="input input-mini" type="text" id="flat1" name="flat1">
                        </div>
                    </div>


                </div>

            </div>

            <div  style="clear: both" class="center">
                <input class="btn btn-primary btn-large" type="submit" value="Добавить студента"/>
            </div>


        </form>




    </body>
</html>
