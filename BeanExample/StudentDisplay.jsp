<%@ page import="com.model.Student" %>
<jsp:useBean id="student" class="com.model.Student" scope="request" />
<p>Name: ${student.name}</p>
<p>Age: ${student.age}</p>
<p>Course: ${student.course}</p>
