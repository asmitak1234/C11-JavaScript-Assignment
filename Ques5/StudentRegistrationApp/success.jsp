<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Success</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #eaf2f8;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .message-box {
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            text-align: center;
            max-width: 500px;
        }

        h2 {
            color: #27ae60;
            margin-bottom: 20px;
        }

        .welcome {
            font-size: 20px;
            color: #34495e;
            margin: 15px 0;
            font-weight: bold;
        }

        .details {
            font-size: 16px;
            color: #2c3e50;
            margin: 10px 0;
        }

        a {
            display: inline-block;
            margin-top: 25px;
            text-decoration: none;
            color: #3498db;
            font-weight: bold;
        }

        a:hover {
            color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="message-box">
        <h2>Registration Successful!</h2>
        <p class="welcome">Welcome, <strong><%= request.getAttribute("studentName") %></strong> 🎓</p>
        <p class="details">We're excited to have you onboard.</p>
        <p class="details">Your age: <strong><%= request.getAttribute("studentAge") %></strong></p>
        <p class="details">Your SGPA: <strong><%= request.getAttribute("studentSGPA") %></strong></p>
        <a href="register.jsp">Register Another Student</a>
    </div>
</body>
</html>
