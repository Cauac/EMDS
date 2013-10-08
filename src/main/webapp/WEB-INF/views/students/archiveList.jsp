<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="emds" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <emds:style/>
        <emds:jquery/>
        <title><emds:title title="Студенты"/></title>
    </head>
    <body>
        <emds:header/>
        <emds:teacherMenu number="1"/>
        <emds:studentsTabs number="4"/>

        <div class="center-div span10">

            <div class="pull-right">
                <select id="faculties" style="margin-left: 20px" onchange="showNewList();">
                    <c:forEach var="faculty" items="${faculties}">
                        <option value="${faculty}">${faculty}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="pull-left">
                <label class="checkbox inline">
                    <input id="reserveCheck" type="checkbox" checked="true" onchange="showNewList();"> Завершившие обучение
                </label>
                <label class="checkbox inline">
                    <input id="dismissedCheck" type="checkbox" checked="true" onchange="showNewList();"> Отчисленные
                </label>
                <label class="checkbox inline">
                    <input id="cancelledCheck" type="checkbox" checked="true" onchange="showNewList();"> Не принятые
                </label>
            </div>
        </div> <br>
        <div style="clear: both"></div>
        <div id="table">
            <c:choose>
                <c:when test="${fn:length(students) gt 0}">

                    <table class="table table-condensed center-div span10">
                        <tr>
                            <th>Студент</th>
                            <th>Факультет</th>
                            <th>Год поступления</th>
                            <th>Статус</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <spring:url var="editStudent" value="/students/edit/${student.id}"/>
                                <td><a href="${editStudent}"> <c:out value="${student.lastName}"/>
                                        <c:out value="${student.firstName}"/> <c:out value="${student.middleName}"/> </a></td>
                                <td>${student.questionnaire.faculty}</td>
                                <td>${student.questionnaire.admissionYear}</td>
                                <td><c:choose>
                                        <c:when test="${student.type eq 'reserve'}">
                                            Лейтенант запаса
                                        </c:when>
                                        <c:when test="${student.type eq 'dismissed'}">
                                            Отчислен
                                        </c:when>
                                        <c:otherwise>
                                            <%-- <c:forEach var="document" items="student.documents">
                                                ${document}
                                            </c:forEach> --%>
                                            Не проходил обучение
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <a href="${editStudent}">
                                        <emds:icon icon="13" text="Редактировать" />
                                    </a>
                                </td>
                                <td>
                                    <spring:url var="removeStudent" value="/students/purge">
                                        <spring:param name="id" value="${student.id}"/>
                                    </spring:url>
                                    <a onclick="return confirm('Вы действительно хотите удалить студента из системы?')"
                                       href="${removeStudent}">
                                        <emds:icon icon="118" text="Удалить из системы" />
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

                </c:when>
                <c:otherwise>
                    <div class="center">
                        <h5>Архив пуст</h5>
                    </div>
                </c:otherwise>

            </c:choose>
        </div>

        <spring:url value="/ajax/archiveList" var="url"/>

        <script type="text/javascript">
            function showNewList() {
                var faculty = $("#faculties").val();
                var reserve = $("#reserveCheck").is(':checked') ? 1 : 0;
                var dismissed = $("#dismissedCheck").is(':checked') ? 1 : 0;
                var cancelled = $("#cancelledCheck").is(':checked') ? 1 : 0;
                var url = '${url}' + '?faculty=' + faculty + '&reserve=' + reserve +
                        '&dismissed=' + dismissed + '&cancelled=' + cancelled;
                $.ajax({
                    type: 'GET',
                    url: url,
                    cache: false,
                    success: function(html) {
                        $("#table").html(html);
                    }
                });
            }
        </script>


    </body>
</html>


