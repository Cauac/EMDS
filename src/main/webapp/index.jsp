<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<html>
    <head>
        <!--        <link href="./resources/css/style.css" rel="stylesheet" type="text/css"/>-->
        <mytags:style />
    </head>
    <body>
        <mytags:menu />
        <h1>Uporot shtole?!</h1>
        <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
        <mytags:footer/>
    </body>
</html>
