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
        <mytags:teacherMenu number="6"/>
        <div class="well offset4 span5">

            <h3 class="center">Добавить студента</h3> 

            <form class="form-horizontal" method="post" action="../students/add">

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

                <!--..............-->

                <div class="center">
                    <input class="btn btn-primary" type="submit" value="Добавить"/>
                    <a class="btn" href="../students"> Назад </a>
                </div>

            </form>
        </div>
    </body>
</html>
