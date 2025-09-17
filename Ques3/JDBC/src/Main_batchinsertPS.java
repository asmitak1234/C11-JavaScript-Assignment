import java.sql.*;
import java.util.Scanner;


public class Main_batchinsertPS {
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

            Scanner scanner = new Scanner(System.in);

            while(true)
            {
                System.out.println("Enter id :");
                int id = scanner.nextInt();
                System.out.println("Enter Name:");
                String name = scanner.next();
                System.out.println("Enter more data ? (Y/N) :");
                String choice = scanner.next();

                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,name);
                preparedStatement.addBatch();

                if(choice.toUpperCase().equals("N"))
                {
                    break;
                }
            }

            int[] arr = preparedStatement.executeBatch();
            for(int i = 0; i< arr.length; i++)
            {
                if(arr[i]==0)
                {
                    System.out.println("Query "+(i+1)+" not executed !!");
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
