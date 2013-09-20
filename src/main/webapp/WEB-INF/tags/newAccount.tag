<%@tag description="Tag, which says to user that he should change his default password" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/personal" var="url"/>

<c:if test="${password ne null}">
    <div class="alert alert-info center center-div span9">
        <c:out value="Учетная запись добавлена. Текущий пароль: ${password}. Рекомендуется сменить после входа." />
        <c:remove var="password"/>
    </div>
</c:if>