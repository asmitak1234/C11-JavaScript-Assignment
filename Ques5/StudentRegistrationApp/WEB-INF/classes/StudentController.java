//1. Create a Java Servlet Class with .java extension

//2. After navigating to your file's folder ,Compile the Servlet with code : "javac -classpath "path/to/servlet-api.jar" servletname.java" in cmd ; The servlet-api.jar is usually found in TOMCAT_HOME/lib

//3. Place the Class File inside: TOMCAT_HOME/webapps/YourApp/WEB-INF/classes/

//4. if you are using jsp file, place it inside YourApp folder, below WEB-INF folder

//5. Configure web.xml as:
//<web-app>
//<servlet>
//<servlet-name>HelloServlet</servlet-name>
//<servlet-class>HelloServlet</servlet-class>
//</servlet>
//<servlet-mapping>
//<servlet-name>HelloServlet</servlet-name>
//<url-pattern>/hello</url-pattern>
//</servlet-mapping>
//</web-app>             and place it in WEB-INF folder where classes folder resides

//6. Start Tomcat ( open shutdown in bin , then startup ; do not close the cmd openend after that )

//7. Access the Servlet by using browser's path to : http://localhost:8080/YourApp/jspfile


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
    private static final String url = "jdbc:mysql://localhost:3306/c11_java_students";
    private static final String username = "root";
    private static final String password = "Asmita#132";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        float sgpa = Float.parseFloat(request.getParameter("sgpa"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String query = "INSERT INTO studentshw (name, age, sgpa) VALUES (?, ?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setString(1, name);
                    ps.setInt(2, age);
                    ps.setFloat(3, sgpa);
                    ps.executeUpdate();
                }
            }
            request.setAttribute("studentName", name);
            request.setAttribute("studentAge", age);
            request.setAttribute("studentSGPA", sgpa);
            RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            throw new ServletException("Database error: " + e.getMessage());
        }
    }
}
