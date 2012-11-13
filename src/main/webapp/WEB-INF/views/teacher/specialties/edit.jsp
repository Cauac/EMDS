<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <mytags:style/>
        <title>ВК ВГУ :: <c:out value="${spec.title}"/></title>
    </head>
    <body>
        <mytags:header />
        <mytags:teacherMenu number="4"/>
        <div class="well offset4 span5">
            <h3 class="center">Редактировать специальность</h3>
            <form class="form-horizontal" method="post" action="../specialties/edit">
                
                <input type="hidden" name="id" value="<c:out value="${spec.id}"/>">
 
                <div id="nameDiv" class="control-group">
                    <label class="control-label" for="title">Название:</label>
                    <div class="controls">
                        <input class="input" type="text" id="title" name="title" value="<c:out value="${spec.title}"/>">
                        <span class="help-inline" ></span>
                    </div>
                </div>

                <div class="center">
                    <input class="btn btn-primary" type="submit" value="Сохранить"/>
                    <a class="btn" href="../specialties"> Назад </a>
                </div>
            </form>
        </div>
    </body>
</html>
