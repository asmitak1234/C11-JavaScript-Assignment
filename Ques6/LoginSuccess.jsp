<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="loginBean" class="com.model.LoginBean" scope="request" />
<html>
<head>
    <title>Login Success</title>
    <style>
        body { font-family: Arial; background-color: #e0ffe0; text-align: center; padding-top: 100px; }
    </style>
</head>
<body>
    <h2>Welcome, ${loginBean.username}!</h2>
    <p>You have successfully logged in.</p>
</body>
</html>
