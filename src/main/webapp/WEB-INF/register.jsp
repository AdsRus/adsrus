<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
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

        #username, #email, #password, #confirm_password {
            width: 940px;
        }

    </style>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
            <form action="/register" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input id="username" name="username" class="form-control" type="text">
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input id="email" name="email" class="form-control" type="text">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" name="password" class="form-control" type="password">
                </div>
                <div class="form-group">
                    <label for="confirm_password">Confirm Password</label>
                    <input id="confirm_password" name="confirm_password" class="form-control" type="password">
                </div>
                <input type="submit" class="btn btn-primary btn-block">
            </form>
    </div>
</body>
</html>
