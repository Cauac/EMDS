<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="emds" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ВК ВГУ :: Личная карточка</title>
    <emds:style/>
    <emds:jquery/>
</head>
<body>
<emds:header/>
<emds:teacherMenu number="3"/>
<spring:url value="/reports/personCard" var="act"/>
<div class="well offset3 span6">
    <h3 class="center">"Личная карточка"</h3>
    <h3 class="center">Параметры отчета</h3>
    <form name="personCard" id="personCard" method="POST" action="${act}">
        <p>Группа: </p>
        <select id="group">
        </select>
        <br>
        <p>Студент: </p>
        <select id="student" name="student">
        </select>
        <br>
        <input class="btn btn-primary" type="submit" value="Создать отчёт"/>
    </form>
</div>

<%-- ajax --%>
<spring:url value="/ajax/allGroups" var="group"/>
<spring:url value="/ajax/studentsByGroup" var="student"/>
<script type="text/javascript">
    $(document).ready(
            // load groups list
            function () {
                $.getJSON('${group}', {
                    ajax: 'true'
                }, function (data) {
                    var html = '<option value="">Выберите группу</option>';
                    var len = data.length;
                    for (var i = 0; i < len; i++) {
                        html += '<option value="' + data[i].id + '">'
                                + data[i].title + '</option>';
                    }
                    html += '</option>';
                    $('#group').html(html);
                });

                // load students list when group is selected
                $('#group').change(
                        function () {
                            $.getJSON('${student}', {
                                groupId: $(this).val(),
                                ajax: 'true'
                            }, function (data) {
                                var html = '<option value="">Выберите студента</option>';
                                var len = data.length;
                                for (var i = 0; i < len; i++) {
                                    html += '<option value="' + data[i].id + '">'
                                            + data[i].lastName + '</option>';
                                }
                                html += '</option>';

                                $('#student').html(html);
                            });
                        });
            });
</script>
</body>
</html>