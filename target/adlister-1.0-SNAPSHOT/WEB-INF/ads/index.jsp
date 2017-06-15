<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
    <link rel="stylesheet" href="/../../css/adsrus.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <style>
        .add-on .input-group-btn > .btn {
            border-left-width:0;left:-2px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        }
        /* stop the glowing blue shadow */
        .add-on .form-control:focus {
            box-shadow:none;
            -webkit-box-shadow:none;
            border-color:#cccccc;
        }
        .form-control{width:20%}
        .navbar-nav > li > a {
            border-right: 1px solid #ddd;
            padding-bottom: 15px;
            padding-top: 15px;
        }
        .navbar-nav:last-child{ border-right:0}

        .btn {
            padding-bottom: 9px;
            padding-top: 9px;
        }

    </style>
</head>

<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <c:if test="${sessionScope.user.username == null}" >
        <h1>Here Are all the ads!</h1>
        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>
            </div>
        </c:forEach>
    </c:if>
    <c:if test="${sessionScope.user.username != null}" >
        <h1>${sessionScope.user.username} - ads!</h1>
        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>
            </div>
        </c:forEach>
    </c:if>

</div>

</body>
</html>
