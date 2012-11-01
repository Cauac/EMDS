<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>

<c:url var="logoURL" value="/resources/images/logo.png">
</c:url>

<div class="emds-footer">
    <mytags:footer/>
    <a class="emds-footer-logo" href="#"> 
        <img class="emds-footer-logo-image" src="${logoURL}" alt="">
    </a>
</div>