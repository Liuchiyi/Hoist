<%--
  Created by IntelliJ IDEA.
  User: liu_chiyi
  Date: 2018/7/11
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="author" content="Kodinger">
    <title>电动葫芦登陆界面</title>
    <link rel="stylesheet" type="text/css" href="../static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../static/css/my-login.css">
</head>

<script>
    if(window.top!==window){
        window.top.location.href=window.location.href;
    }
</script>

<body class="my-login-page">
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="brand">
                    <img  src="../static/img/timg.jpg">
                </div>
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">用户登陆</h4>
                        <form action="login.do"method="POST">

                            <div class="form-group">
                                <label >账号</label>

                                <input id="account"  class="form-control" name="account" value="0001" required autofocus>
                            </div>
                            <div class="form-group">
                                <label for="password">密码
                                    <strong>${message}</strong>
                                    <a href="forgot.html" class="float-right">
                                        忘记密码?
                                    </a>
                                </label>
                                <input id="password" type="password" class="form-control" name="password" required data-eye>
                            </div>

                            <div class="form-group">
                                <label>
                                    <input type="checkbox" name="remember"> 记住我
                                </label>
                            </div>

                            <div class="form-group no-margin">
                                <button type="submit" class="btn btn-primary btn-block">
                                    登陆
                                </button>
                            </div>
                            <div class="margin-top20 text-center">
                                没有账号？ <a href="registerpage.do">创建账号</a>
                            </div>
                        </form>
                    </div>
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