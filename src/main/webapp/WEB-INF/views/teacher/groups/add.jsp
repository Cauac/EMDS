<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <mytags:style/>
        <title>�� ��� :: ������</title>
    </head>
    <body>
        <mytags:header />
        <mytags:teacherMenu number="4"/>
        <div>
            <h4>����� ������</h4>
            <form method="post" action="../groups/add">
                <label for="title">��������:</label>
                <input type="text" name="title" /><br />
                <select>
                    <c:forEach var="spec" items="${specialties}">
                        <option value="${spec.id}">${spec.title}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="��������"/>
                <a class="btn" href="../groups"> ����� </a>
            </form>
        </div>
    </body>
</html>
