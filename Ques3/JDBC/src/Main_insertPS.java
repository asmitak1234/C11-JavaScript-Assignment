import java.sql.*;

public class Main_insertPS {
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

            String query="INSERT INTO students VALUES(?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"Susmita");

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0)
            {
                System.out.println("Data Inserted Successfully! "+rowsAffected);
            }
            else
            {
                System.out.println("Data Not Inserted !");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
