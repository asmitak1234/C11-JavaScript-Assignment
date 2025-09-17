package com.model;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uname = request.getParameter("username");
        String pwd = request.getParameter("password");

        LoginBean bean = new LoginBean();
        bean.setUsername(uname);
        bean.setPassword(pwd);

        request.setAttribute("loginBean", bean);

        if (bean.validate()) {
            RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("LoginFailure.jsp");
            rd.forward(request, response);
        }
    }
}
