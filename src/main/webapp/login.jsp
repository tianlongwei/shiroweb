<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form method="post" action="/login">
    <table>
        <caption>登录</caption>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
                <input type="submit" name="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
