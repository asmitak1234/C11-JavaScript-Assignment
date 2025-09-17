import java.sql.*;

public class Main_selectallanddisplay {
    // Connection Essentials
    public static final String url ="jdbc:mysql://localhost:3306/c11_java_students";
    public static final String username ="root";
    public static final String password="Asmita#132";
    public static void main(String[] args) {
        try {
            // Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try{
            Connection connection=DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query= "select * from students";
            ResultSet resultSet= statement.executeQuery(query);
            while(resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: "+id);
                System.out.println("NAME: "+name);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
