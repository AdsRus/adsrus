<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <c:if test="${sessionScope.user.username != null}" >
            <div class="navbar-header">
                <a class="navbar-brand" href="/profile">Home</a>
            </div>
        </c:if>
        <c:if test="${sessionScope.user.username == null}" >
            <div class="navbar-header">
                <a class="navbar-brand" href="/">Home</a>
            </div>
        </c:if>
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>

        <c:if test="${sessionScope.user.username == null}" >
        <div class="navbar-header">
            <a class="navbar-brand" href="/register">Register</a>
        </div>
        </c:if>
        <c:if test="${sessionScope.user.username != null}" >
            <div class="navbar-header">
                <a class="navbar-brand" href="/ads/create">Create Ad</a>
            </div>
        </c:if>
        <c:if test="${sessionScope.user.username == null}" >
        </c:if>
        <ul class="nav navbar-nav navbar-right">

            <c:if test="${sessionScope.user != null}">
                <li><a href="/logout">Logout</a></li>
            </c:if>

            <c:if test="${sessionScope.user == null}">
                <li><a href="/login">Login</a></li>
            </c:if>
        </ul>

    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
