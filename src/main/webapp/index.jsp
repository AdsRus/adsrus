<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome" />
    </jsp:include>
    <link rel="stylesheet" href="/css/adsrus.css">
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
    <c:if test="${sessionScope.user != null}">
    </c:if>
    <c:if test="${sessionScope.user == null}">
        <jsp:include page="/WEB-INF/partials/navbar.jsp" />
        <div class="container">
            <h1>Welcome to ads-R-us</h1>
        </div>
    </c:if>

</body>
</html>
