<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <mytags:style/>
        <title>ВК ВГУ :: Специальности</title>
    </head>
    <body>
        <mytags:header />
        <h4>Новая специальность</h4>
        <form method="post" action="addSpeciality.htm">
            <label for="name">Title:</label>
            <input type="text" name="title" /><br />
            <input type="submit" value="Add"/>
            <input type="reset" />
        </form>
    </body>
</html>
