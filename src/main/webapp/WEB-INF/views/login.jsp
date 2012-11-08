<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<html>
    <head>
        <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <mytags:style />
    </head>
    <body>

        <mytags:header />
        <div class="well offset4 span8">
            <h1 style="text-align: center">Electronic military department</h1>


            <c:if test="${not empty error}">
                <div class="alert alert-error offset2 span3" style="text-align: center;">
                    Login error : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                </div>
            </c:if>

            <form style="text-align: center" method="post" action="./j_spring_security_check">
                <p><input type="text" name="j_username" value="" placeholder="Login"></p>
                <p><input type="password" name="j_password" value="" placeholder="Password"></p>
                <!-- <p class="pull-left">
                     <label>
                         <input type="checkbox" name="_spring_security_remember_me" id="remember_me">
                         Remember me
                     </label>
                 </p>-->
                <input class="btn btn-primary loginButton" type="submit" name="commit" value="Login">
            </form>

            <!--<div>
        
                <p>Forgot your password? <a href="index.html">Click here to reset it</a>.</p>
        
            </div>-->
        </div>

    </body>
</html>