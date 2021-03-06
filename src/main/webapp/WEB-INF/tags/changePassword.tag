<%@tag description="Tag, which says to user that he should change his default password" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url value="/personal" var="url"/>
<c:if test="${defPass ne null}">
    <spring:url value="/personal" var="personal"/>
    <div class="alert alert-warning center center-div span9">
        После первого входа в систему рекомендуется <a href="${personal}"
                                                       style="color: white; text-decoration: underline"> сменить пароль
        учетной записи </a>.
    </div>
</c:if>