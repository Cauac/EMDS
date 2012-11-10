<%-- 
    Document   : addSpeciality
    Created on : 30.09.2012, 14:50:02
    Author     : Max
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <mytags:jquery />
        <mytags:style />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>JSP Page</title>
    </head>
    <body>
        <mytags:header />
        <mytags:menu />
        <h4>New Speciality</h4>
        <form method="post" action="addSpeciality.htm">
            <label for="name">Title:</label>
            <input type="text" name="title" /><br />
            <input type="submit" value="Add"/>
            <input type="reset" />
        </form>
        <mytags:footer/>
    </body>
</html>
