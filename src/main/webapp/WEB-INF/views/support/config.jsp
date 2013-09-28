<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<%@ page import="by.vsu.emdsproject.common.EMDSContext" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><emds:title title="Конфигурация"/></title>
    <emds:style/>
</head>
<body>
<emds:header/>
<div class="well center-div span8">
    <h2>Файл лицензии</h2>
    <p class="lead"><%= EMDSContext.getInstance().getEnvironment().getProperty("reports.license") %></p>
</div>
</body>
</html>