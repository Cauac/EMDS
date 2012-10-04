<%-- 
    Document   : addGroup
    Created on : 01.10.2012, 9:54:35
    Author     : 21vek
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>JSP Page</title>
    </head>
    <body>
        <mytags:menu/>
        <h4>New Group</h4>
        <form method="post" action="addGroup.htm">
            <label for="title">Title:</label>
            <input type="text" name="title" /><br />
            <label for="speciality_id">Speciality_id</label>
            <input type="text" name="speciality_id" /><br />
            <input type="submit" value="Add"/>
            <input type="reset" />
        </form>
        <mytags:footer/>
    </body>
</html>
