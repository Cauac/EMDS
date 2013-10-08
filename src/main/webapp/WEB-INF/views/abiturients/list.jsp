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
        <emds:jquery/>
        <title><emds:title title="Поступающие"/></title>
    </head>
    <body>

        <emds:header/>
        <emds:teacherMenu number="1"/>
        <emds:win-fail/>
        <emds:studentsTabs number="1"/>

        <div class="span11 center-div">
            <label class="select-and-input inline">
                Фильтр по факультетам: 
                <select id="faculties" style="margin-left: 20px" onchange="showNewList();">
                    <c:forEach var="faculty" items="${faculties}">
                        <option value="${faculty}">${faculty}</option>
                    </c:forEach>
                </select>
            </label>
        </div>

        <div id="table">
            <c:choose>
                <c:when test="${fn:length(abiturients) gt 0}">
                    <table class="table table-condensed table-bordered span11 center-div">
                        <tr class="thead">
                            <th style="width: 200px"></th>
                            <th><p style="text-align: center">Факультет</p></th>
                            <c:forEach var="document" items="${documents}">
                            <th><p style="text-align: center"><c:out value="${document.title}"/></p></th>
                        </c:forEach>
                        <th></th>
                        </tr>
                        <c:forEach var="abiturient" items="${abiturients}">
                            <tr class="tbody">
                                <td><c:out value="${abiturient.lastName}"/> <c:out value="${abiturient.firstName}"/>
                                    <c:out value="${abiturient.middleName}"/></td>

                                <td><p style="text-align: center"><c:out value="${abiturient.questionnaire.faculty}"/></p></td>

                                <c:forEach var="document" items="${documents}">
                                    <c:choose>
                                        <c:when test="${abiturient.documents.get(document).brought eq true}">
                                            <c:choose>
                                                <c:when test="${document.systemTitle ne 'score'}">
                                                    <td style="text-align: center; color: green">
                                                        <p title="${abiturient.documents.get(document).commentary}">✓</p></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td style="text-align: center;"> ${abiturient.documents.get(document).commentary} </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                        <c:otherwise>
                                            <spring:url var="addDocument" value="/documents/{document}">
                                                <spring:param name="document" value="${document.systemTitle}"/>
                                                <spring:param name="id" value="${abiturient.id}"/>
                                            </spring:url>
                                            <td style="text-align: center"><a href="${addDocument}">добавить</a></td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>

                                <c:choose>
                                    <c:when test="${readiness.get(abiturient)}">
                                        <spring:url var="studentialize" value="/abiturients/studentialize">
                                            <spring:param name="id" value="${abiturient.id}"/>
                                        </spring:url>
                                        <td style="width:30px"><a href="${studentialize}">
                                                <emds:icon icon="104" text="Перевести в студенты" />
                                            </a>
                                        </td>
                                    </c:when>
                                    <c:otherwise>
                                        <spring:url value="/abiturients/remove" var="remove">
                                            <spring:param name="id" value="${abiturient.id}"/>
                                        </spring:url>
                                        <td style="width:30px">
                                            <a onclick="return confirm('Вы действительно хотите перенести информацию о студенте в архив?')"
                                               href="${remove}">
                                                <emds:icon icon="115" text="Отказать в приеме" />
                                            </a>
                                        </td>
                                    </c:otherwise>
                                </c:choose>

                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <h5 class="center">Список пуст</h5>
                </c:otherwise>
            </c:choose>
        </div>

        <br>
        <div class="center">
            <spring:url value="/abiturients/add" var="addAbiturient"/>
            <a class="btn" style="margin-bottom: 25px" href="${addAbiturient}">
                <emds:icon icon="112" text="Добавить абитуриента"/>Добавить поступающего
            </a>
        </div>

        <spring:url value="/ajax/abiturientsList" var="url"/>

        <script type="text/javascript">
            function showNewList() {
                var faculty = $("#faculties").val(); //$("#reserveCheck").is(':checked') ? 1 : 0;
                var url = '${url}' + '?faculty=' + faculty;
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
