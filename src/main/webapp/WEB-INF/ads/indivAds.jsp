<%--
  Created by IntelliJ IDEA.
  User: bichtran
  Date: 6/14/17
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing SPecific Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Specific ad!</h1>


    <c:forEach var="ad" items="${ads}">

        <div class="col-md-6">
            <h5>Ad Id: ${ad.id}</h5>
            <h2>Ad title: ${ad.title}</h2>
            <p>Description of the ad:  ${ad.description}</p>

        </div>
    </c:forEach>
</div >
<div class="col-md-6">
    <div class="thumbnail">
            <img src="https://www.w3schools.com/w3images/nature.jpg" alt="Nature" style="width:100%">
            <div class="caption">
                <p>Comming soon.</p>
            </div>
    </div>
</div>
</body>
</html>