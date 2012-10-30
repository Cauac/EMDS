<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<html>
    <head>
        <mytags:style />
    </head>
    <body>
        <mytags:menu />
        <h2>Uporot shtole?!</h2>
        <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
        <mytags:footer/>
    </body>
</html>
