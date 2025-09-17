import java.sql.*;

public class Main_selectallPS {
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
            Connection connection= DriverManager.getConnection(url,username,password);

            String query="SELECT name FROM students WHERE id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,2);

            ResultSet resultSet= preparedStatement.executeQuery();
            if(resultSet.next())
            {
                String name = resultSet.getString("name");
                System.out.println("NAME: "+name);
            }
            else
            {
                System.out.println("Name not found !");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
