<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@tag description="icon plus text for buttons or links" pageEncoding="UTF-8"%>
<%@attribute name="icon" required="true" %>
<%@attribute name="size" %>
<%@attribute name="text"%>


<spring:url value="/resources/images/icons/${icon}.png" var="path"/>
<img src="${path}" alt="${text}" title="${text}" width="${size ? size : 24 }px" height="${size ? size : 24}px"/>
