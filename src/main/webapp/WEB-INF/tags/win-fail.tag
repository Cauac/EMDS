<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="width"%>

<c:if test="${win ne null}">
    <div class="alert alert-success center center-div span9">
        <c:out value="${win}" />
        <c:remove var="win"/>
    </div>
</c:if>

<c:if test="${fail ne null}">
    <div class="alert alert-error center center-div span9">
        <c:out value="${fail}" />
        <c:remove var="fail"/>
    </div>
</c:if>