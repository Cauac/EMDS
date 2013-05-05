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
<spring:url value="/reports/..." var="act"/>
<form:form name="personCard" id="personCard" modelAttribute="personCardForm" method="POST" action="${act}">
    <form:select path="group" id="groups">
    </form:select>
    <form:select path="student" id="students">
    </form:select>
</form:form>

<%-- ajax --%>
<spring:url value="/ajax/allGroups" var="groups"/>
<spring:url value="/ajax/studentsByGroup" var="students"/>
<script type="text/javascript">
    $(document).ready(
            // load groups list
            function () {
                $.getJSON('${groups}', {
                    ajax: 'true'
                }, function (data) {
                    var html = '<option value="">Выберите группу</option>';
                    var len = data.length;
                    for (var i = 0; i < len; i++) {
                        html += '<option value="' + data[i].id + '">'
                                + data[i].title + '</option>';
                    }
                    html += '</option>';
                    $('#groups').html(html);
                });

                // load students list when group is selected
                $('#groups').change(
                        function () {
                            $.getJSON('${students}', {
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

                                $('#students').html(html);
                            });
                        });
            });
</script>
</body>
</html>