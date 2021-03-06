<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="emds" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <emds:style/>
        <emds:js/>
        <title><emds:title title="Преподаватели"/></title>
        
    </head>
    <body>
        <emds:header/>
        <emds:teacherMenu number="6"/>
        <emds:newAccount/>

        <c:if test="${fn:length(teachers) gt 0}">
            <table class="table table-condensed center-div span9">
                <tr class="thead">

                    <th></th>
                    <th>Преподаватель</th>
                    <th></th>
                    <th style="text-align: center">Логин</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="teacher" items="${teachers}">
                    <tr class="tbody">
                        <td style="text-align: center; vertical-align: middle">
                            <c:if test="${teacher.chief}">
                                <emds:icon icon="33" text="Начальник кафедры" />
                            </c:if></td>

                            <td class="span4" style="vertical-align: middle">${teacher.lastName} ${teacher.firstName} ${teacher.middleName}</td>

                        <td class="span2">
                            <c:choose>
                                <c:when test="${teacher.rank eq 'Младший лейтенант'}">
                                    <spring:url value="/resources/images/pog/ml.png" var="pogimg"/>
                                </c:when>
                                <c:when test="${teacher.rank eq 'Лейтенант'}">
                                    <spring:url value="/resources/images/pog/lt.png" var="pogimg"/>
                                </c:when>
                                <c:when test="${teacher.rank eq 'Старший лейтенант'}">
                                    <spring:url value="/resources/images/pog/sl.png" var="pogimg"/>
                                </c:when>
                                <c:when test="${teacher.rank eq 'Капитан'}">
                                    <spring:url value="/resources/images/pog/kp.png" var="pogimg"/>
                                </c:when>
                                <c:when test="${teacher.rank eq 'Майор'}">
                                    <spring:url value="/resources/images/pog/mj.png" var="pogimg"/>
                                </c:when>
                                <c:when test="${teacher.rank eq 'Подполковник'}">
                                    <spring:url value="/resources/images/pog/pp.png" var="pogimg"/>
                                </c:when>
                                <c:when test="${teacher.rank eq 'Полковник'}">
                                    <spring:url value="/resources/images/pog/pl.png" var="pogimg"/>
                                </c:when>
                            </c:choose>
                            <img src="${pogimg}" width="124px" height="43px" alt="${teacher.rank}">
                        </td>


                        <td style="text-align: center; vertical-align: middle"><c:forEach items="${users}" var="user">
                                <c:if test="${user.personId eq teacher.id}">
                                    <c:out value="${user.login}"/>
                                </c:if>
                            </c:forEach></td>

                        <td style="vertical-align: middle">
                            <spring:url var="editTeacher" value="/teachers/edit">
                                <spring:param name="id" value="${teacher.id}"/>
                            </spring:url>
                            <a href="${editTeacher}">
                                <emds:icon icon="13" text="Редактировать" />
                            </a>
                        </td>
                        <td style="vertical-align: middle">
                            <spring:url var="removeTeacher" value="/teachers/remove">
                                <spring:param name="id" value="${teacher.id}"/>
                            </spring:url>
                            <a onclick="return confirm('Вы действительно хотите удалить преподавателя?')"
                               href="${removeTeacher}">
                                <emds:icon icon="118" text="Удалить преподавателя" />
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <br>
        <div class="center">
            <spring:url var="addTeacher" value="/teachers/add"/>
            <spring:url var="chief" value="/teachers/chief"/>
            <a class="btn" href="${addTeacher}">
                <emds:icon icon="112" text="Добавить преподавателя" /> Добавить преподавателя
                <!--<i class="icon-plus icon-white"></i>-->
            </a>
            <a class="btn" href="${chief}">
                <!--<i class="icon-flag"></i>--> 
                <emds:icon icon="33" text="Задать начальника кафедры" /> Задать начальника кафедры
            </a>
        </div>

    </body>
</html>
