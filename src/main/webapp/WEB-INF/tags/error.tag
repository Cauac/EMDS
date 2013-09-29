<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute required="true" name="message"%>

<div id="message" class="alert alert-error center center-div span6">
    <c:out value="${message}" />
</div>
<br>