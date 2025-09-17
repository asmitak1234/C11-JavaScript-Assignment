package com.servlet;

import java.io.*;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.servlet.*;

public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String course = request.getParameter("course");

        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setCourse(course);

        request.setAttribute("student", student);
        RequestDispatcher rd = request.getRequestDispatcher("StudentDisplay.jsp");
        rd.forward(request, response);
    }
}
