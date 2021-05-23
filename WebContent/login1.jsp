<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登入界面</title>
    <style type="text/css">
        *{
            margin: 0px;
            padding: 0px;
            font-family: microsoft yahei;
        }
        html,body{
            background-image: url(static/img/login-bg.png);
            background-size: 100% 100%;
            height: 100%;
        }
        .login{
            position: absolute;
            background-color: rgba(255 , 255 , 255, 1);
            top: 25%;
            left: 35%;
            right: 35%;
            bottom: 25%;
            border-radius: 5px;
        }
        .title,.u,.p,.l,.tips,.s{
            position: absolute;
            width: 100%;
        }
        input{
            height: 35%;
            border:0px;
            border-radius: 5px;
            width: 80%;
            padding-left: 18px;
            box-sizing: border-box;
        }
        .uname{
            background: url(static/img/login_user.png) no-repeat left;
            background-color: #F2F2FA;
        }
        .pwd{
            background: url(static/img/login_pwd.png) no-repeat left;
            background-color: #F2F2FA;
        }
        button{
            background-color: #F2F2FA;
            height: 35px;
            width: 80%;
            border-radius: 5px;
            color: cyan;
            font-size: 16px;
        }
        select{
            width: 80%;
            height: 35px;
            border-radius: 5px;
            border: 1px solid #999999;
        }
        .title{
            top:0px;
            bottom: 80%;
            text-align: center;
            font-size: 25px;
            font-weight: bold;
            padding-top: 10px;
            box-sizing: border-box;
        }
        .u{
            top: 20%;
            bottom: 60%;
            left: 10%;
        }
        .p{
            top: 40%;
            bottom: 40%;
            left: 10%;
        }
        .s{
            top: 57%;
            bottom: 13%;
            left: 10%;
        }
        .l{
            top: 75%;
            bottom: 15%;
            left: 10%;
        }
        .tips{
            top: 90%;
            font-size: 13px;
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="login" >
    <div class="title" >
        学生选课系统
    </div>
    <form action="login" method="post">
        <div class="u" >
            <input type="text" class="uname" name="userName" value="" />
        </div>
        <div class="p" >
            <input type="text" class="pwd" name="password" value="" />
        </div>
        <div class="s" >
            <select name="type">
                <option value="">请选择登入类型</option>
                <option value="0">学生</option>
                <option value="1">老师</option>
                <option value="2">管理员</option>
            </select>
        </div>
        <div class="l" >
            <button type="submit" value="登入"/>
        </div>
    </form>
    <div class="tips">
        ${error}
    </div>
</div>
</body>
</html>
