<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login Form</title>
    <style>
        body { font-family: Arial; background-color: #f0f0f0; }
        .form-box {
            background: white; padding: 20px; margin: 100px auto;
            width: 300px; box-shadow: 0 0 10px gray;
        }
        input[type=text], input[type=password] {
            width: 100%; padding: 8px; margin: 8px 0;
        }
        input[type=submit] {
            background-color: #4CAF50; color: white;
            padding: 10px; border: none; width: 100%;
        }
    </style>
</head>
<body>
    <div class="form-box">
        <h2>Login</h2>
        <form action="login" method="post">
            <label>Username:</label>
            <input type="text" name="username" required />
            <label>Password:</label>
            <input type="password" name="password" required />
            <input type="submit" value="Login" />
        </form>
    </div>
</body>
</html>
