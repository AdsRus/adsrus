<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <c:if test="${sessionScope.user != null}">

    </c:if>
    <c:if test="${sessionScope.user == null}">
        <jsp:include page="/WEB-INF/partials/navbar.jsp" />
        <div class="container">
            <h1>Welcome to AdsRus!</h1>
        </div>
    </c:if>

</body>
</html>
