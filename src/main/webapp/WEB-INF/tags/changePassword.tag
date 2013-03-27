<%@tag description="Tag, which says to user that he should change his default password" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/personal" var="url"/>
<c:if test="${defPass ne null}">
    <div class="alert alert-warning center offset2 span9">
        После первого входа в систему рекомендуется <a href="${pageContext.servletContext.contextPath}/personal"
                                                       style="color: white; text-decoration: underline"> сменить пароль
        учетной записи </a>.
    </div>
</c:if>