<%--
  Created by IntelliJ IDEA.
  User: yuan_hao
  Date: 2022/12/21
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>欢迎注册</title>
        <link href="css/register.css" rel="stylesheet">
    </head>
    <body>

        <div class="form-div">
            <div class="reg-content">
                <h1>欢迎注册</h1>
                <span>已有帐号？</span> <a href="login.html">登录</a>
            </div>
            <form id="reg-form" action="/Chapter12-brand-demo/registerServlet" method="post">

                <table>
                    <tr>
                        <td>用户名</td>
                        <td class="inputs">
                            <input name="username" type="text" id="username">
                            <br>
                            <%--<span id="username_err" class="err_msg">${register_msg}</span>--%>
                            <span id="username_err" class="err_msg" style="display: none">用户名已存在</span>
                        </td>

                    </tr>

                    <tr>
                        <td>密码</td>
                        <td class="inputs">
                            <input name="password" type="password" id="password">
                            <br>
                            <span id="password_err" class="err_msg" >${register_msg}</span>
                        </td>
                    </tr>


                    <tr>
                        <td>验证码</td>
                        <td class="inputs">
                            <input name="checkCode" type="text" id="checkCode">
                            <img id="checkCodeImg" src="/Chapter12-brand-demo/checkCodeServlet">
                            <a href="#" id="changeImg">看不清？</a>
                        </td>
                    </tr>
                </table>

                <div class="buttons">
                    <input value="注 册" type="submit" id="reg_btn">
                </div>
                <br class="clear">
            </form>

        </div>
        <script src="js/axios-0.18.0.js"></script>
        <script>
            //1. 给用户名输入框绑定 失去焦点事件
            document.getElementById("username").onblur = function () {
                var username = this.value;
                //2. 发送ajax请求
                axios.get("http://localhost:8080/Chapter12-brand-demo/registerServlet2?username=" + username).then(function (resp) {
                    if (resp.data == false) {
                        //用户名存在，显示提示信息
                        document.getElementById("username_err").style.display = '';
                    } else {
                        //用户名不存在 ，清楚提示信息
                        document.getElementById("username_err").style.display = 'none';
                    }
                })
            }
            document.getElementById("changeImg").onclick = function () {
                document.getElementById("checkCodeImg").src = "/Chapter12-brand-demo/checkCodeServlet?" + new Date().getMilliseconds();
            }

            document.getElementById("checkCodeImg").onclick = function () {
                document.getElementById("checkCodeImg").src = "/Chapter12-brand-demo/checkCodeServlet?" + new Date().getMilliseconds();
            }
        </script>
    </body>
</html>
