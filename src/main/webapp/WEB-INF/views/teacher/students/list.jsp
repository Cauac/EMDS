<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <mytags:style/>
        <title>ВК ВГУ :: Студенты</title>
    </head>
    <body>
        <mytags:header/>
        <mytags:changePassword />
        <mytags:teacherMenu number="1" />
        


        <c:if test="${fn:length(students) gt 0}">
            <table class="table table-condensed offset1 span11">
                <tr>
                    <th>ФИО</th>
                    <th>Специальность</th>
                    <th>Группа</th>
                    <th>Логин</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td> <a href="./students/info?id=<c:out value="${student.id}" />"> <c:out value="${student.lastName}" /> <c:out value="${student.firstName}" /> <c:out value="${student.middleName}" /> </a> </td>
                        <td><c:out value="${student.group.specialty.title}" /> </td>
                        <td><c:out value="${student.group.title}" /> </td>
                        <td><c:forEach items="${users}" var="user">
                                <c:if test="${user.personId eq student.id}">
                                    <c:out value="${user.login}"/>
                                </c:if>
                            </c:forEach></td>
                        <td>
                            <a href="./students/edit?id=<c:out value="${student.id}" />">
                                <i title="Редактировать" class="icon-edit"></i>
                            </a>
                        </td>
                        <td>
                            <a onclick="return confirm('Вы действительно хотите удалить студента?')" href="./students/remove?id=<c:out value="${student.id}" />">
                                <i title="Удалить студента" class="icon-remove"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <div class="offset1 span11">
            <a class="offset4 btn btn-primary" title="Beta" href="./students/add" >
                <i class="icon-plus icon-white"></i> Добавить студента
            </a>
        </div>
    </body>
</html>
