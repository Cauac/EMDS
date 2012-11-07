
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container">
    <section class="login">
        <h1>Electronic military department</h1>

        <div style="text-align: center">
        <c:if test="${not empty error}">
            <font color="red"> Login error
            : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
        </c:if>
        </div>
        
        <form method="post" action="./j_spring_security_check">
            <p><input type="text" name="j_username" value="" placeholder="Login"></p>
            <p><input type="password" name="j_password" value="" placeholder="Password"></p>
            <p class="remember_me">
                <label>
                    <input type="checkbox" name="_spring_security_remember_me" id="remember_me">
                    Remember me
                </label>
            </p>
            <p class="submit"><input type="submit" name="commit" value="Login"></p>
        </form>
    </section>

    <section class="login-help">
        <p>Forgot your password? <a href="index.html">Click here to reset it</a>.</p>
    </section>
</div>
