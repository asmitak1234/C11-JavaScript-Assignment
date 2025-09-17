<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
    <form action="StudentServlet" method="post">
        Name: <input type="text" name="name" /><br/>
        Age: <input type="number" name="age" /><br/>
        Course: <input type="text" name="course" /><br/>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
