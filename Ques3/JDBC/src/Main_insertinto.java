import java.sql.*;

public class Main_insertinto {
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
            Statement statement = connection.createStatement();

            String query=String.format("INSERT INTO students VALUES(%d,'%s')",2,"Susmita");

            int rowsAffected = statement.executeUpdate(query);
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
