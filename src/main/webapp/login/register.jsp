<%--
  Created by IntelliJ IDEA.
  User: liu_chiyi
  Date: 2018/7/11
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="author" content="Kodinger">
    <title>注册页面</title>
    <link rel="stylesheet" type="text/css" href="../static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../static/css/my-login.css">
</head>
<body class="my-login-page">
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="brand">
                    <img src="../static/img/logo.jpg">
                </div>
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">注册</h4>
                        <strong>${message}</strong>
                        <form action="register.do" method="POST">

                            <div class="form-group">
                                <label >账号</label>
                                <input id="account" type="text" class="form-control" name="account" required autofocus>
                            </div>

                            <div class="form-group">
                                <label for="name">姓名</label>
                                <input id="name" type="text" class="form-control" name="name" required autofocus>
                            </div>

                            <div class="form-group">
                                <label for="email">邮箱</label>
                                <input id="email" type="email" class="form-control" name="email" required>
                            </div>

                            <div class="form-group">
                                <label for="password">密码</label>
                                <input id="password" type="password" class="form-control" name="password" required data-eye>
                            </div>

                            <div class="form-group">
                                <label>
                                    <input type="checkbox" name="aggree" value="1"> 我同意各项条款
                                </label>
                            </div>

                            <div class="form-group no-margin">
                                <button type="submit" class="btn btn-primary btn-block">
                                    注册
                                </button>
                            </div>
                            <div class="margin-top20 text-center">
                                已有账号？ <a href="loginpage.do">登陆</a>
                            </div>
                        </form>
                    </div>er
                </div>
                <div class="footer">
                    Copyright &copy; Your Company 2018
                </div>
            </div>
        </div>
    </div>
</section>

<script src="../static/js/jquery.min.js"></script>
<script src="../static/bootstrap/js/bootstrap.min.js"></script>
<script src="../static/js/my-login.js"></script>
</body>
</html>
